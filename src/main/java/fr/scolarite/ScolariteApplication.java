package fr.scolarite;

import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import fr.scolarite.dao.EtudiantRepository;
import fr.scolarite.model.Etudiant;

//
//@Author Mouloudi
//
@SpringBootApplication
public class ScolariteApplication {

	public static void main(String[] args) throws ParseException {
		ApplicationContext ctx=SpringApplication.run(ScolariteApplication.class, args);
		
	//	EtudiantRepository etudiantRepository=ctx.getBean(EtudiantRepository.class);
		
		//DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		
		/// Ajouter les données dans la base
		//etudiantRepository.save(new Etudiant("Ali", "ali@ali", df.parse("2019-01-10"), "ali.jpg"));
		//etudiantRepository.save(new Etudiant("Mohammed", "med@ali", df.parse("1983-01-01"),"med.jpg"));
		
		//Page<Etudiant> etds= etudiantRepository.findByNom("Ali",new PageRequest(0,5));
		//etds.forEach((e->System.out.println(e.getNom())));
	}

}
