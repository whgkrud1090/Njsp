package kr.or.ddit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.filter.wrapper.DefaultCompanyCodeWrapper;

@WebFilter("/*")
public class DefaultCompanyCodeFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		DefaultCompanyCodeWrapper wrapper = new DefaultCompanyCodeWrapper((HttpServletRequest)request);
		
//		chain.doFilter(request, response);
		chain.doFilter(wrapper, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
