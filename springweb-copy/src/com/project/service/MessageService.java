package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.MessageDAO;
import com.project.model.Message;

@Component("messageSer")
public class MessageService {
	
	@Autowired
	private MessageDAO msgDao;

	@Transactional
	public int saveMessage(Message msg) {
		
		return msgDao.saveMessage(msg);
	}
	@Transactional
	public List<Message> getAllMessages() {
		
		return msgDao.getAllMessages();
	}
	@Transactional
	public List<Message> getFromMessages(String username) {
		
		return msgDao.getFromMessages(username);
	}
	@Transactional
	public List<Message> getMessagesForAdmin(String name) {
		
		return msgDao.getMessagesForAdmin(name);
	}

}
