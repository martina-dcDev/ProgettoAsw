package it.uniroma3.asw.romatre;

import org.springframework.beans.factory.annotation.Autowired;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public class DirettoreDipartimentoServiceImpl implements DirettoreDipartimentoService {

	@Autowired
	private DirettoreDipartimentoClient capoDipClient;

	@HystrixCommand(fallbackMethod="getFallbackDipartimento")
	public String getCapoDip(String dipartimento) {
		return this.capoDipClient.getDirettore(dipartimento);
	}
	
	/* ------------ FALLBACK methods ------------ */ 
	public String getFallbackGiudDep(){
		return "{err}";
	}

}
