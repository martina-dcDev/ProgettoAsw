package it.uniroma3.asw.r2;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class R2Controller {

	@Autowired
	Environment env;
	
	private final Logger logger = Logger.getLogger("it.uniroma3.asw.r2");

	@RequestMapping("/{dipartimento}")
	public String getGiudizio(@PathVariable String dipartimento){
		String[] dipartimenti = env.getProperty("dipartimenti").split(", ");
		String[] indicatori = env.getProperty("indicatori").split(", ");
		
		dipartimento = dipartimento.toLowerCase();

		boolean trovato = false;
		for(String dip : dipartimenti){
			if(dip.equals(dipartimento))
				trovato = true;
		}
		if(!trovato){
			return env.getProperty("errore.giudizio.dipartimento");
		}
		int somma = 0;
		for (String indicatore : indicatori){
			int value = Integer.parseInt(this.recuperaGiudizio(dipartimento, indicatore));
			somma += value;
		}

		String mediaGiudizio = String.valueOf(((int)(somma/indicatori.length)));
		logger.info("getGiudizio(" + dipartimento + "): " + mediaGiudizio);
		return mediaGiudizio;
	}

	@RequestMapping("/{dipartimento}/{indicatore}")
	public String getGiudizioParziale(@PathVariable String dipartimento, @PathVariable String indicatore){
		String[] dipartimenti = env.getProperty("dipartimenti").split(", ");
		String[] indicatori = env.getProperty("indicatori").split(", ");

		dipartimento = dipartimento.toLowerCase();
		indicatore = indicatore.toLowerCase();
		
		boolean trovatoDip = false;
		boolean trovatoInd = false;
		for(String dip : dipartimenti){
			if(dip.equals(dipartimento)){
				trovatoDip = true;
			}
		}
		if(!trovatoDip){
			return env.getProperty("errore.giudizio.dipartimento");
		}
		for(String ind : indicatori){
			if(ind.equals(indicatore)){
				trovatoInd = true;
			}	
		}
		if(!trovatoInd){
			return env.getProperty("errore.indicatore.giudizio");
		}
		String giudizioParziale = this.recuperaGiudizio(dipartimento, indicatore);
		logger.info("getGiudizioParziale(" + dipartimento + ", " + indicatore + "): " + giudizioParziale);
		return giudizioParziale;
	}

	/* Metodo privato che recupera il giudizio sull'indicatore del dipartimento dal file di properties*/
	private String recuperaGiudizio(String dipartimento,String indicatore){

		String giudizio = env.getProperty("giudizi." + dipartimento + "." + indicatore);
		String[] giudizioArray = giudizio.split(",");

		int i = (int)(Math.random()*(giudizioArray.length-1));

		return giudizioArray[i];
	}
}
