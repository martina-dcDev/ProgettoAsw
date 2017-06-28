package it.uniroma3.asw.r1;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class R1Controller {

	@Autowired
	Environment env;

	private final Logger logger = Logger.getLogger("it.uniroma3.asw.r1");

	@RequestMapping("/{dipartimento}")
	public String getDirettore(@PathVariable String dipartimento){
		dipartimento = dipartimento.toLowerCase();
		String[] dipartimenti = env.getProperty("dipartimenti").split(", ");

		boolean trovato = false;
		for(String dip : dipartimenti){
			if(dip.equals(dipartimento))
				trovato = true;
		}
		if(!trovato) {
			String errore = env.getProperty("errore.dipartimento");  
			logger.info("getDirettore(" + dipartimento + "): " + errore);
			return errore;
		}
		/* ---------------- */

		String direttori = env.getProperty("direttori." + dipartimento);
		String[] direttoriArray = direttori.split(", ");
		
		int i = (int)(Math.random()*(direttoriArray.length-1));
		String direttore = direttoriArray[i];

		logger.info("getDirettore(" + dipartimento + "): " + direttore);
		return direttore;

	}
}
