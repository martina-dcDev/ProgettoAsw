package it.uniroma3.asw.romatre;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RomaTreController {

	private final Logger logger = Logger.getLogger("it.uniroma3.asw.romatre");

	@Value("${romatre.direttoredipartimento.uri}")
	private String direttoredipartimentoUri;

	@Value("${romatre.giudizi.uri}")
	private String giudiziUri;

	@RequestMapping("/RomaTre/{dipartimento}")
	public String getSomeInfo(@PathVariable String dipartimento) {
		dipartimento = dipartimento.toLowerCase();
		
		String capoDip = this.getCapoDip(dipartimento);
		String giudizio = this.getGiudizio(dipartimento);
		
		if(rispostErrata(capoDip)) return capoDip;
		else if (rispostErrata(giudizio)) return giudizio;
		
		String answ = "Il direttore del dipartimento di " + dipartimento +
			" e': " + capoDip +
			" e il valore medio del giudizio di soddisfazione degli studenti" +
			" di questo dipartimento e': " + giudizio + "/10.";
		
		logger.info("getSomeInfo(" + dipartimento + "): " + answ);
		return answ;
	}

	@RequestMapping("/RomaTre/{dipartimento}/{indicatore}")
	public String getFullInfo(@PathVariable String dipartimento, @PathVariable String indicatore) {
		dipartimento = dipartimento.toLowerCase();
		indicatore = indicatore.toLowerCase();
		
		String capoDip = this.getCapoDip(dipartimento);
		String giudizio = this.getGiudizio(dipartimento, indicatore);
		
		if(rispostErrata(capoDip)) return capoDip;
		else if (rispostErrata(giudizio)) return giudizio;		
		
		String answ = "Il direttore del dipartimento di " + dipartimento +
			" e': " + capoDip +
			" e il valore medio del giudizio di soddisfazione degli studenti" +
			" relativo all'indicatore \"" + indicatore + "\" di questo dipartimento e': " + giudizio + "/10.";
		
		logger.info("getFullInfo(" + dipartimento + ", " + indicatore + "): " + answ);
		return answ;
	}
	
	private boolean rispostErrata(String risposta){
		return risposta.contains("{");
	}

	private String getAnsw(String uri) {
		return new RestTemplate().getForObject(uri,String.class);
	}

	private String getCapoDip(String dipartimento) {
		return this.getAnsw(direttoredipartimentoUri + "/" + dipartimento);
	}

	private String getGiudizio(String dipartimento) {
		return this.getAnsw(giudiziUri + "/" + dipartimento);
	}

	private String getGiudizio(String dipartimento, String indicatore) {
		return this.getAnsw(giudiziUri + "/" + dipartimento + "/" + indicatore);
	}

}
