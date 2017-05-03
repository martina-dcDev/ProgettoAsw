package it.uniroma3.asw.romatre;

import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RomaTreController {

	private final Logger logger = Logger.getLogger("it.uniroma3.asw.romatre");

	@Value("${romatre.capodipartimento.uri}")
	private String capodipartimentoUri;

	@Value("${romatre.giudizi.uri}")
	private String giudiziUri;

	@RequestMapping("/")
	public String getHome() {
		logger.info("getHome()");
		return "<h1>Welcome to RomaTre</h1>" +
			"<p>You can search for RomaTre/dipartimento or RomaTre/dipartimento/indicatore</p>";
	}

	@RequestMapping("/RomaTre/{dipartimento}")
	public String getSomeInfo(Map<String, Object> model, @PathVariable String dipartimento) {
		String answ = "Il capo del dipartimento di " + dipartimento +
				" è: " + this.getCapoDip(dipartimento) +
				".\nIl voto medio di questo dipartimento è: " + this.getGiudizio(dipartimento) + "/10.";
		logger.info("getSomeInfo(" + dipartimento + "): " + answ);
		return answ;
	}

	@RequestMapping("/RomaTre/{dipartimento}/{indicatore}")
	public String getFullInfo(Map<String, Object> model, @PathVariable String dipartimento, @PathVariable String indicatore) {
		String answ = "Il capo del dipartimento di " + dipartimento +
				" è: " + this.getCapoDip(dipartimento) +
				".\nIl voto riguardo \"" + indicatore + "\" è: " + this.getGiudizio(dipartimento, indicatore) + "/10.";
		logger.info("getFullInfo(" + dipartimento + ", " + indicatore + "): " + answ);
		return answ;
	}

	private String getAnsw(String uri) {
		return new RestTemplate().getForObject(uri,String.class);
	}

	private String getCapoDip(String dipartimento) {
		return this.getAnsw(capodipartimentoUri + "/" + dipartimento);
	}

	private String getGiudizio(String dipartimento) {
		return this.getAnsw(giudiziUri + "/" + dipartimento);
	}

	private String getGiudizio(String dipartimento, String indicatore) {
		return this.getAnsw(giudiziUri + "/" + dipartimento + "/" + indicatore);
	}

}
