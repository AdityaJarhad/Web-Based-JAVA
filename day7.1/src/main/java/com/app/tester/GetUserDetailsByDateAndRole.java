package com.app.tester;

import static com.app.entities.Role.valueOf;
import static com.app.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.UserDao;
import com.app.dao.UserDaoImpl;
import com.app.entities.User;

public class GetUserDetailsByDateAndRole {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			// create user dao instance
			UserDao userDao = new UserDaoImpl();
			System.out.println("Enter start, end date and role");
			List<User> list = userDao.getUsersByDobAndRole(LocalDate.parse(sc.next()), LocalDate.parse(sc.next()), valueOf(sc.next().toUpperCase()));
		
					list.forEach(u -> System.out.println(u));
		} // JVM sf.close() => cleaning up of DBCP
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
