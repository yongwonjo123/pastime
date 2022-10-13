package kr.ac.onmh.util.interceptor;

import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

import kr.ac.onmh.model.Member;

public class UserInterceptor extends HandlerInterceptorAdapter {

	// 로그인을 확인하는 Interceptor
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();

		Member user = (Member) session.getAttribute("user");

		if (user == null) {
//			로그인 페이지로 이동한다
			response.sendRedirect("/login");
//			로그인이 필요한 페이지라고 메시지를 보낸다
			FlashMap flashMap = new FlashMap();
			flashMap.put("err_msg", "로그인이 필요합니다");
			FlashMapManager manager = RequestContextUtils.getFlashMapManager(request);
			manager.saveOutputFlashMap(flashMap, request, response);

//			원래 가려고 했던 곳을 저장한다
			URL url = new URL(request.getRequestURL().toString() + "?" + request.getQueryString());

			String query = "?" + url.getQuery();
			String target = url.getPath() + (query != null ? query : "");

			session.setAttribute("dest_path", target);

			return false;
		}
		return true;
	}

}
