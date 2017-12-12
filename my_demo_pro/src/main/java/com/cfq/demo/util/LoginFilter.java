package com.cfq.demo.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cfq.demo.entity.User;

public class LoginFilter implements Filter {
	FilterConfig filterConfig;
	private String[] noFilter;
	private String excludedPages;  
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		excludedPages = filterConfig.getInitParameter("noFilter");  
		if (!excludedPages.isEmpty()) {  
			noFilter = excludedPages.split(",");  
		}  
		return;  
		}  

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 获得在下面代码中要用的request,response,session对象
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();
		
		// 获得用户请求的URI
		String path = servletRequest.getRequestURI();
		User user = (User) session.getAttribute("user");
		for (int i = 0; i < noFilter.length; i++) {
			if (path.indexOf(noFilter[i]) >-1) {
				chain.doFilter(servletRequest, servletResponse);
				return;
			}
		}
		if (user == null) {
			String getPath=request.getScheme()+"://"+request.getServerName()+":"+ request.getServerPort()+""+request.getServletContext().getContextPath()+ "/madmin/page/login.do";
			servletResponse.sendRedirect(getPath);
			return;
		} else{
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		

	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
