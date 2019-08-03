package fr.scolarite.web;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fr.scolarite.dao.EtudiantRepository;
import fr.scolarite.model.Etudiant;

@Controller
@RequestMapping(value="etudiant")
public class EtudiantController {
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Value("${dir.images}")
	private String imageDir;
	
	@RequestMapping(value="/index")
	public String index(Model model,@RequestParam(name="page",defaultValue="0")int p,
			@RequestParam(name="motCle",defaultValue="")String mc) {
		Page<Etudiant> etds=etudiantRepository.chercherEtudiant(mc+"%",new PageRequest(p,5));
		
		int pageCount=etds.getTotalPages();
		int[] pages=new int[pageCount];
		for(int i=0;i<pageCount;i++) pages[i]=i;
		model.addAttribute("pageEtudiants", etds);
		model.addAttribute("pages",pages);
		model.addAttribute("pageCourante",p);
		model.addAttribute("motCle",mc);
		return "etudiants";
	}
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String formEtudiant(Model model) {
		model.addAttribute("etudiant",new Etudiant());
		return "FormEtudiant";
	}
	
	@RequestMapping(value="/saveEtudiant",method=RequestMethod.POST)
	public String save(@Valid Etudiant etudiant, BindingResult bindingResult, @RequestParam(name="picture")MultipartFile fichier ) throws Exception {
		if(bindingResult.hasErrors()) {
			return "formEtudiant";
		}
		
		if (!(fichier.isEmpty())) {
			etudiant.setPhoto(fichier.getOriginalFilename());
			fichier.transferTo(new File(System.getProperty("users.home")+"/images/"+fichier.getOriginalFilename()));
		}
		etudiantRepository.save(etudiant);
		return "redirect:index";
	}
}
