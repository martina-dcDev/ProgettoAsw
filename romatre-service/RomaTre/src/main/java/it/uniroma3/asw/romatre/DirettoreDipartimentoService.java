package it.uniroma3.asw.romatre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import it.uniroma3.asw.romatre.clients.DirettoreDipartimentoClient;

@Service
public class DirettoreDipartimentoService {

	@Autowired
	private DirettoreDipartimentoClient direttoreDipClient;

	@HystrixCommand(fallbackMethod="getFallbackDipartimento")
	public String getDirettoreDip(String dipartimento) {
		return this.direttoreDipClient.getDirettore(dipartimento);
	}
	
	/* ------------ FALLBACK methods ------------ */ 
	public String getFallbackDipartimento(String dipartimento){
		return "{err on get direttore (" + dipartimento + ")}";
	}

}
