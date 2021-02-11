package br.com.bmo.taskmanager.auth;

import br.com.bmo.taskmanager.dao.FakeDB;
import br.com.bmo.taskmanager.model.User;

public class Authenticate {

	public boolean canAccess(String login, String pwd) {
		
		FakeDB fakeDB = new FakeDB();
		User user = fakeDB.selectUserByLogin(login);
		
		System.out.println(login + "user.canLogin? " + user.canLogin(login, pwd));
		
		if (user != null && user.canLogin(login, pwd)) {
			return true;
		}
		
		return false;
	}
}
