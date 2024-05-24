package com.app.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.utils.HibernateUtils;

public class BlogPostTester {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);
				SessionFactory sf = HibernateUtils.getFactory()){
			System.out.println("");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
