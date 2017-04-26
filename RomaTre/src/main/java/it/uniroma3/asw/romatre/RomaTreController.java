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

	@Value("${romatre.prof.uri}")
	private String profUri;

	@Value("${romatre.aule.uri}")
	private String auleUri;

	@RequestMapping("/")
	public String getHome() {
		logger.info("getHome()");
		return "<h1>Welcome to RomaTre</h1>";
	}

	@RequestMapping("/{dipartimento}")
	public String getSomeInfo(Map<String, Object> model, @PathVariable String dipartimento) {
		String answ = "Nel dipartimento di " + dipartimento +
				" sono presenti i seguenti professori: " +	getProf(dipartimento) +
				".\nSono a disposizione degli studenti le seguenti aule: " + getAule(dipartimento) + ".";
		logger.info("getSomeInfo(" + dipartimento + "): " + answ);
		return answ;
	}

	@RequestMapping("/{dipartimento}/{orario}")
	public String getFullInfo(Map<String, Object> model, @PathVariable String dipartimento, @PathVariable String orario) {
		String answ = "Nel dipartimento di " + dipartimento +
				" sono presenti i seguenti professori: " +	getProf(dipartimento) +
				".\nLe aule libere nell'orario indicato sono: " + getAule(dipartimento, orario) + ".";
		logger.info("getFullInfo(" + dipartimento + ", " + orario + "): " + answ);
		return answ;
	}

	private String getAnsw(String uri) {
		return new RestTemplate().getForObject(uri,String.class);
	}

	private String getProf(String dipartimento) {
		return getAnsw(profUri + "/" + dipartimento);
	}

	private String getAule(String dipartimento) {
		return getAnsw(auleUri + "/" + dipartimento);
	}

	private String getAule(String dipartimento, String orario) {
		return getAnsw(auleUri + "/" + dipartimento + "/" + orario);
	}

}
