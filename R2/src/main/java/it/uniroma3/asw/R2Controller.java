package it.uniroma3.asw;

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
	
	private final Logger logger = Logger.getLogger("it.uniroma3.asw");
	
	@RequestMapping("/R2/{dipartimento}")
	public String getGiudizio(@PathVariable String dipartimento){
		
		String giudizioAule = this.recuperaGiudizio(dipartimento, env.getProperty("aule"));
		logger.info("giudizio aule " + giudizioAule);
		String giudizioEsercitazioni = this.recuperaGiudizio(dipartimento, env.getProperty("esercitazioni"));
		logger.info("giudizio esercitazioni " + giudizioEsercitazioni);
		String giudizioInsegnamento = this.recuperaGiudizio(dipartimento, env.getProperty("insegnamento"));
		logger.info("giudizio insegnamento " + giudizioInsegnamento);
		String giudizioLezioni = this.recuperaGiudizio(dipartimento, env.getProperty("lezioni"));
		logger.info("giudizio lezioni " + giudizioLezioni);
		
		
		String mediaGiudizio = calcolaMediaGiudizio(giudizioAule, giudizioEsercitazioni, giudizioInsegnamento, giudizioLezioni);
		logger.info("media giudizio " + mediaGiudizio);
		
		return mediaGiudizio;
	}
	
	@RequestMapping("/R2/{dipartimento}/{indicatore}")
	public String getGiudizioParziale(@PathVariable String dipartimento, @PathVariable String indicatore){
		
		String giudizioParziale = this.recuperaGiudizio(dipartimento,indicatore);
		
		return giudizioParziale;
	}
	
	/* Metodo privato che calcola la media dei valori dei giudizi su tutti gli indicatori di un dato dipartimento*/
	private String calcolaMediaGiudizio(String giudizioAule, String giudizioEsercitazioni, String giudizioInsegnamento, String giudizioLezioni){
		int valoreGiudizioAule = Integer.parseInt(giudizioAule);
		int valoreGiudizioEsercitazioni = Integer.parseInt(giudizioEsercitazioni);
		int valoreGiudizioInsegnamento = Integer.parseInt(giudizioInsegnamento);
		int valoreGiudizioLezioni = Integer.parseInt(giudizioLezioni);
		
		int mediaGiudizio = (valoreGiudizioAule+valoreGiudizioEsercitazioni+valoreGiudizioInsegnamento+valoreGiudizioLezioni)/4;
		logger.info("media giudizio " + mediaGiudizio);
		
		String giudizio = String.valueOf(mediaGiudizio);
		return giudizio;
	}
	
	/* Metodo privato che recupera il giudizio sull'indicatore del dipartimento dal file di properties*/
	private String recuperaGiudizio(String dipartimento,String indicatore){
		logger.info("dipartimento " + dipartimento);
		logger.info("indicatore " + indicatore);
		String value = "giudizi."+dipartimento+"."+indicatore;
		
		String giudizio = env.getProperty(value);
		logger.info("giudizio " + giudizio);
		
		String[] giudizioArray = giudizio.split(",");
		
		int i = (int)(Math.random()*(giudizioArray.length-1));		
		String valoreGiudizio = giudizioArray[i];
		return valoreGiudizio; 
	}
}
