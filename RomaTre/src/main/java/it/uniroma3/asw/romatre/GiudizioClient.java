package it.uniroma3.asw.romatre;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("giudizio")
public interface GiudizioClient {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getGiudizio(String dipartimento);
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getGiudizio(String dipartimento, String indicatore);
}
