package it.uniroma3.asw.romatre.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import feign.Param;

@FeignClient("giudizio")
public interface GiudizioClient {
	
	@RequestMapping(value="/R2/{dipartimento}", method=RequestMethod.GET)
	public String getGiudizio(@Param("dipartimento") String dipartimento);
	
	@RequestMapping(value="/R2/{dipartimento}/{indicatore}", method=RequestMethod.GET)
	public String getGiudizio(@Param("dipartimento") String dipartimento, @Param("indicatore") String indicatore);
}
