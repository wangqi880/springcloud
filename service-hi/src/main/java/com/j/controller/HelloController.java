package com.j.controller;

import com.j.ServiceHiApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2017/7/25.
 */
@RestController
public class HelloController
{
	private static final Logger LOG = Logger.getLogger(HelloController.class.getName());

	@Value ("${server.port}")
	String port;

	@RequestMapping ("/hi")
	public String hi(@RequestParam String name)
	{
		return "hi,"+name+",i am from port:"+port;
	}


	@RequestMapping("/info")
	public String info(@RequestParam String info){
		LOG.log(Level.INFO, "calling trace service-hi ");
		return "i am service-hi"+info;
	}
}
