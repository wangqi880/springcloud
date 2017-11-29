package com.j.controller;

import com.j.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/7/28.
 */
@RestController
public class HiController
{
	@Autowired SchedualServiceHi schedualServiceHi;

	@RequestMapping(value = "/hi")
	String sayHi(@RequestParam String name){
		return schedualServiceHi.hi(name);
	}


}
