package it.uniroma3.asw.romatre.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("r2")
public interface GiudizioClient {
	
	@RequestMapping(value="/R2/{dipartimento}", method=RequestMethod.GET)
	public String getGiudizio(@PathVariable(value="dipartimento") String dipartimento);
	
	@RequestMapping(value="/R2/{dipartimento}/{indicatore}", method=RequestMethod.GET)
	public String getGiudizioParziale(@PathVariable(value="dipartimento") String dipartimento, @PathVariable(value="indicatore") String indicatore);
}
