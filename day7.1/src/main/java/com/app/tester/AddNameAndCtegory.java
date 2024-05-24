package com.app.tester;

import java.util.Scanner;
import static com.app.utils.HibernateUtils.getFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.dao.CategoryDao;
import com.app.dao.CategoryDaoImpl;
import com.app.entities.Category;

public class AddNameAndCtegory {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);
				SessionFactory sf = getFactory() ) {
			CategoryDao categoryDao = new CategoryDaoImpl();
			System.out.println("Enter category name");
			String name = sc.next();
			sc.nextLine();
			System.out.println("Enter category description");
			String description = sc.nextLine();
			Category transientCategory =  new Category(description, name);
			System.out.println(categoryDao.addNameAndDescription(transientCategory));
						
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
