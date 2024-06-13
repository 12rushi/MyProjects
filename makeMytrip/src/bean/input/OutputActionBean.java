package bean.input;

import javax.servlet.http.HttpServletRequest;

public class OutputActionBean {
	
	public LoginBean userLogin(HttpServletRequest request){
		LoginBean loginBean = new LoginBean();
		loginBean.setEmailId(request.getParameter("userName"));
		loginBean.setPassword(request.getParameter("password"));
		
		return loginBean;
	}
	
	public Admin userAdmin(HttpServletRequest request){
		Admin admin = new Admin();
		admin.setAdminName(request.getParameter("userName"));
		admin.setAdminPassword(request.getParameter("password"));
		
		return admin;
	}
}
