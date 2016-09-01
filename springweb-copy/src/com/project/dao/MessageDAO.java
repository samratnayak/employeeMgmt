package com.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.model.Message;
import com.project.model.User;

@Component
public class MessageDAO {
	@Autowired
	private SessionFactory sessionfac;

	public int saveMessage(Message msg) {
		Session session = sessionfac.getCurrentSession();
		session.save(msg);
		session.flush();
		return msg.getId();
	}
	public List<Message> getAllMessages() {
		Session session = sessionfac.getCurrentSession();
		List<Message> messageList = session.createQuery("from Message").list();
		session.flush();
		return messageList;
	}
	public List<Message> getFromMessages(String username) {
		User user = new User();
		user.setUsername(username);
		Session session = sessionfac.getCurrentSession();
		Criteria cr = session.createCriteria(Message.class);
		cr.add(Restrictions.eq("msg_from", user));
		List<Message> msgList= cr.list();
		session.flush();
		return msgList;
	}
	public List<Message> getMessagesForAdmin(String name) {
		/*Session session = sessionfac.getCurrentSession();
		Criteria cr = session.createCriteria(Message.class);
		cr.add(Restrictions.eq("userid", ));
		List<Message> msgList= cr.list();
		session.flush();*/
		return null;
	}

}
