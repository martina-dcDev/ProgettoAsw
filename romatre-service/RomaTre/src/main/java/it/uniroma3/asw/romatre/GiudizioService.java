package it.uniroma3.asw.romatre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import it.uniroma3.asw.romatre.clients.GiudizioClient;

@Service
public class GiudizioService {

	@Autowired
	private GiudizioClient giudizioClient;

	@HystrixCommand(fallbackMethod="getFallbackGiudDep")
	public String getGiudizio(String dipartimento) {
		return this.giudizioClient.getGiudizio(dipartimento);
	}

	@HystrixCommand(fallbackMethod="getFallbackGiudDepInd")
	public String getGiudizio(String dipartimento, String indicatore) {
		return this.giudizioClient.getGiudizioParziale(dipartimento, indicatore);
	}
	
	/* ------------ FALLBACK methods ------------ */ 
	public String getFallbackGiudDep(String dipartimento){
		return "{error on get giudizio (" + dipartimento + ")}";
	}
	
	public String getFallbackGiudDepInd(String dipartimento, String indicatore){
		return "{err on get giudizio (" + dipartimento + ", " + indicatore + ")}";
	}

}
