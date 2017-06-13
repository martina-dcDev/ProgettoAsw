package it.uniroma3.asw.romatre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class GiudizioServiceImpl implements GiudiziService {

	@Autowired
	private GiudizioClient giudizioClient;

	@HystrixCommand(fallbackMethod="getFallbackGiudDep")
	public String getGiudizio(String dipartimento) {
		return this.giudizioClient.getGiudizio(dipartimento);
	}

	@HystrixCommand(fallbackMethod="getFallbackGiudDepInd")
	public String getGiudizio(String dipartimento, String indicatore) {
		return this.giudizioClient.getGiudizio(dipartimento, indicatore);
	}
	
	/* ------------ FALLBACK methods ------------ */ 
	public String getFallbackGiudDep(){
		return "{err}";
	}
	
	public String getFallbackGiudDepInd(){
		return "{err}";
	}

}
