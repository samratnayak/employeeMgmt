package com.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionProvider {

	private static Session session;
	private static Configuration cfg;
	private static SessionFactory fac;

	public static Session getSession() {
		cfg = new Configuration();
		cfg.configure("/resource/hibernate.cfg.xml");
		fac = cfg.buildSessionFactory();
		session = fac.openSession();
		return session;
	}
}
