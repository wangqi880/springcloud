package com.j.service;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/7/28.
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi
{
	@Override public String hi(String name2)
	{
		return "sorry "+name2;
	}
}
