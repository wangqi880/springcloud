package com.j.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2017/8/6.
 * 如果是调用负载均衡的来做，不能查看依赖（应该可以只是我不知道现在）
 */
@RestController
public class MyACtion
{
	private static final Logger LOG = Logger.getLogger(MyACtion.class.getName());
	@Autowired RestTemplate restTemplate;

	@RequestMapping ("/hi")
	public String home(){
		LOG.log(Level.INFO, "hi is being called");
		return "hi i'm miya!";
	}

	@RequestMapping("/miya")
	public String info(){
		LOG.log(Level.INFO, "info is being called");
		return restTemplate.getForObject("http://localhost:8763/hi?name="+"miya",String.class);
	}

}
