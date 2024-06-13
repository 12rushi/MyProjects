package ajaxhandler;

import dao.Dao;

public class AjaxHandler {
	

	public int checkLogin(String emailId, String password) {
		
		return Dao.verifyCredentials(emailId, password);
	}
	
	public boolean checkLoginAdmin(String emailId, String password) {
			
			return Dao.verifyCredentialsAdmin(emailId, password);
		}
	}
