package it.uniroma3.asw.r1;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class R1Controller {
	
	@Autowired
	Environment env;
	
	private final Logger logger = Logger.getLogger("it.uniroma3.asw.r1");
	
	@RequestMapping("/R1/{dipartimento}")
	public String getDirettore(@PathVariable String dipartimento) {
		
		dipartimento = dipartimento.toLowerCase();
		String valore = "direttori"+"."+dipartimento;
		String direttori = env.getProperty(valore);
		String[] direttoriArray = direttori.split(",");
		int i = (int)(Math.random()*(direttoriArray.length-1));		
		String direttore = direttoriArray[i];
		logger.info("getDirettore(" + dipartimento + "): " + direttore);
		return direttore; 
		
	}
}
