package it.uniroma3.asw;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class R2Controller {

	@Value("${giudizi.aule}")
	private String giudiziAule;
	
	@Value("${giudizi.esercitazioni}")
	private String giudiziEsercitazioni;
	
	@Value("${giudizi.insegnamento}")
	private String giudiziInsegnamento;
	
	@Value("${giudizi.lezioni}")
	private String giudiziLezioni;
	
	@Value("${errore.giudizio}")
	private String erroreGiudizio;
	
	@RequestMapping("/")
	public String getGiudizio(){
	   int giudizio = (int)(Math.random()*10);
	   return String.valueOf(giudizio);
	}
	
	@RequestMapping("/{indicatore}")
	public String getGiudizioParziale(@PathVariable String indicatore){
		String[] giudizioArray;
		if("aule".equals(indicatore)){
			giudizioArray = giudiziAule.split(",");
		}
		else if("esercitazioni".equals(indicatore)){
			giudizioArray = giudiziEsercitazioni.split(",");
		}
		else if("insegnamento".equals(indicatore)){
			giudizioArray = giudiziInsegnamento.split(",");
		}
		else if("lezioni".equals(indicatore)){
		 giudizioArray = giudiziLezioni.split(",");
		}
		else{
			return erroreGiudizio;
		}
		int i = (int)(Math.random()*4);
		String giudizio = giudizioArray[i];
		return giudizio; 
	}
}
