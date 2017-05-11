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
		try {
			String answ = "Il direttore del dipartimento di " + dipartimento.toLowerCase() +
				" �: " + this.getCapoDip(dipartimento) +
				" e il valore medio del giudizio di soddisfazione degli studenti" +
				" di questo dipartimento �: " + this.getGiudizio(dipartimento) + "/10.";
			logger.info("getSomeInfo(" + dipartimento + "): " + answ);

			return answ;
		} catch(Exception e){
			return e.getMessage();
		}
	}

	@RequestMapping("/RomaTre/{dipartimento}/{indicatore}")
	public String getFullInfo(@PathVariable String dipartimento, @PathVariable String indicatore) {
		try {
			String answ = "Il direttore del dipartimento di " + dipartimento.toLowerCase() +
				" �: " + this.getCapoDip(dipartimento) +
				" e il valore medio del giudizio di soddisfazione degli studenti" +
				" relativo all'indicatore \"" + indicatore.toLowerCase() + "\" di questo dipartimento �: " + this.getGiudizio(dipartimento, indicatore) + "/10.";
			logger.info("getFullInfo(" + dipartimento + ", " + indicatore + "): " + answ);
			
			return answ;
		} catch(Exception e){
			return e.getMessage();
		}
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
