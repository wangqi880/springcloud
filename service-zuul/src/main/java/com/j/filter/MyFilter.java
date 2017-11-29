package com.j.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Administrator on 2017/8/6.
 * filterType：返回一个字符串代表过滤器的类型
 * pre：路由之前，routing：路由之时，post： 路由之后，error：发送错误调用，filterOrder：过滤的顺序
 * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤
 * run：过滤器的具体逻辑可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问
 */
@Component
public class MyFilter extends ZuulFilter
{
	private static Logger log =  LoggerFactory.getLogger(MyFilter.class);


	@Override public String filterType()
	{
		return "pre";
	}

	@Override public int filterOrder()
	{
		return 0;
	}

	@Override public boolean shouldFilter()
	{
		return true;
	}

	@Override public Object run()
	{
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request= ctx.getRequest();
		log.info(String.format("%s>>>%s",request.getMethod(),request.getRequestURI().toString()));
		Object accessToken = request.getParameter("token");
		if(accessToken==null) {
			log.warn("token is null");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			try
			{
				ctx.getResponse().getWriter().write("token is empty");
			}
			catch (IOException e)
			{
			}
			log.info("ok");
		}
		return null;
	}
}
