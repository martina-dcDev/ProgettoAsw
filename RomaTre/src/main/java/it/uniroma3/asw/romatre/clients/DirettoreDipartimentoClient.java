package it.uniroma3.asw.romatre.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("R1")
public interface DirettoreDipartimentoClient {
	
	@RequestMapping(value="/R1/{dipartimento}", method=RequestMethod.GET)
	public String getDirettore(@PathVariable("dipartimento") String dipartimento);
}
