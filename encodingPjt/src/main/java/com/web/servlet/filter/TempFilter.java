package com.web.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TempFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		System.out.println("-- Filter init() --");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("-- Filter doFilter() --");

		// Filter로 한글 처리 시 필수 세 코드 [참고] https://hayden-archive.tistory.com/207
		// 요청 및 응답 한글 처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		// 사전 작업(위에서 처리한 한글 처리 작업)의 내용이 서버상의 다음 컴포넌트에게 계속 적용되기 위한 작업
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {

		System.out.println("-- Filter destroy() --");

	}

}
