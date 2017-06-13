package it.uniroma3.asw.romatre;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomaTreController {

	private final Logger logger = Logger.getLogger("it.uniroma3.asw.romatre");

	@Autowired private DirettoreDipartimentoService direttoredipartimentoService;
	@Autowired private GiudiziService giudiziService;

	@RequestMapping("/RomaTre/{dipartimento}")
	public String getSomeInfo(@PathVariable String dipartimento) {
		dipartimento = dipartimento.toLowerCase();

		String capoDip = this.direttoredipartimentoService.getCapoDip(dipartimento);
		String giudizio = this.giudiziService.getGiudizio(dipartimento);

		if (containsError(capoDip))
			return capoDip;
		else if (containsError(giudizio))
			return giudizio;

		String answ = "Il direttore del dipartimento di " + dipartimento + " e': " + capoDip
				+ " e il valore medio del giudizio di soddisfazione degli studenti" + " di questo dipartimento e': "
				+ giudizio + "/10.";

		logger.info("getSomeInfo(" + dipartimento + "): " + answ);
		return answ;
	}

	@RequestMapping("/RomaTre/{dipartimento}/{indicatore}")
	public String getFullInfo(@PathVariable String dipartimento, @PathVariable String indicatore) {
		dipartimento = dipartimento.toLowerCase();
		indicatore = indicatore.toLowerCase();

		String capoDip = this.direttoredipartimentoService.getCapoDip(dipartimento);
		String giudizio = this.giudiziService.getGiudizio(dipartimento, indicatore);

		if (containsError(capoDip))
			return capoDip;
		else if (containsError(giudizio))
			return giudizio;

		String answ = "Il direttore del dipartimento di " + dipartimento + " e': " + capoDip
				+ " e il valore medio del giudizio di soddisfazione degli studenti" + " relativo all'indicatore \""
				+ indicatore + "\" di questo dipartimento e': " + giudizio + "/10.";

		logger.info("getFullInfo(" + dipartimento + ", " + indicatore + "): " + answ);
		return answ;
	}

	private boolean containsError(String risposta) {
		return risposta.contains("{");
	}
}
