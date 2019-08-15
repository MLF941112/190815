package cn.sz.lyr.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginIntercepter implements HandlerInterceptor {
	
	private String[]arr= {"uc/login","","bc/findall","bc/findbyid"};
	
	public boolean checkUrl(String myurl) {
		if(myurl.endsWith(".jpg")||myurl.endsWith(".png")||myurl.endsWith(".css")||myurl.endsWith(".js")){
			return true;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(myurl)) {
				return true;
			}
		}
		return false;
	}

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("请求完成后的操作");
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("方法执行后的操作");
	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("myusers");
		
		String path = request.getContextPath();
		String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		if(obj==null){	
			String uri = request.getRequestURI();
			String myurl = null;
			if(uri.contains(";jsessionid")){
				myurl = uri.substring(path.length()+1,uri.indexOf(";jsessionid"));
			}else{
				myurl = uri.substring(path.length()+1);
			}
			System.out.println("myurl:"+myurl);
			if(this.checkUrl(myurl)){
				return true;
			}
			
			response.sendRedirect(basepath+"uc/login");
		}
		return true;
	}

}
