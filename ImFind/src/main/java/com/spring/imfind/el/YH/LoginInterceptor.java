package com.spring.imfind.el.YH;

import javax.servlet.http.Cookie;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter implements SessionName {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		Object user = session.getAttribute(LOGIN);
		
		if(session.getAttribute(LOGIN) != null) {
			session.removeAttribute(LOGIN);
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("logincheck postHandle");
		HttpSession session = request.getSession();
		Object loginUser =  request.getSession().getAttribute(LOGIN);
		
		if(loginUser != null) {

			System.out.println("로그인한 유저 : " + (String)loginUser);
			
			// 비밀번호 기억 선택 시 쿠키 생성
			if(!(StringUtils.isEmpty(request.getParameter("savePass")))) {
				Cookie loginCookie = new Cookie(LOGIN_COOKIE, session.getId());
				loginCookie.setPath("/imfind");
				loginCookie.setMaxAge(1 * 24 * 60 * 60); // 24시간 동안 쿠키 유지
				
				response.addCookie(loginCookie);
			}
		}
		super.postHandle(request, response, handler, modelAndView);

	}
	
}
