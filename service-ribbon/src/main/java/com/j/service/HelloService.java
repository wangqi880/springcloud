package com.j.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/7/28.
 */
@Service
public class HelloService
{
	@Autowired
	RestTemplate restTemplate;

	//中断器，如果底层服务失败之后，返回一个默认值
	@HystrixCommand (fallbackMethod = "hiError")
	public String hiService(String name)
	{
		return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
	}

	public String hiError(String name){
		return "hi,"+name+",sorry,error!";
	}
}
