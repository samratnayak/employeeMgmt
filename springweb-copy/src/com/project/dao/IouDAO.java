package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.Iou;

@Component(value="ioudao")
public class IouDAO {
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Iou> getIou() {
		// TODO Auto-generated method stub
		List<Iou> l = new ArrayList<Iou>();
		Session s = sessionFactory.getCurrentSession();
		l = s.createQuery("from Iou").list();
		s.flush();
		return l;
	}

}
