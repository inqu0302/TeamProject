package com.callor.WOO.data;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/server")
public class ServerController {
	
	
	@ResponseBody
	@RequestMapping(value="/location",method=RequestMethod.POST)
	public String location(String latitude,String longitude) {
		
		log.debug("la {}, lo {}", latitude, longitude);
		
		return "OK";
		
	}

}
