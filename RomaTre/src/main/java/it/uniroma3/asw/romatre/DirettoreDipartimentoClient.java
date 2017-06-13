package it.uniroma3.asw.romatre;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("direttore")
public interface DirettoreDipartimentoClient {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getDirettore(String dipartimento);
}
