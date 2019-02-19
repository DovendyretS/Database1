package test;


import java.util.List;

import dal.IUserDAO;
import dal.IUserDAO.DALException;
import dal.UserDAO;
import dto.UserDTO;

public class DBTester {
	//TODO refactor as JUnit test???
	public static void main(String[] args) {
		UserDTO newUser = new UserDTO();
		IUserDAO iDAO = new UserDAO();

		/*
		//TODO test new fields...
		newUser.setIni("test");
		newUser.addRole("Admin");
		newUser.setUserName("testName");
		newUser.setUserId(0);
		*/

		try {
			//iDAO.createUser(newUser);
			iDAO.deleteUser(1);
		} catch (DALException e) {
			e.printStackTrace();
		}

		System.out.println(newUser.toString());

		}

	}
