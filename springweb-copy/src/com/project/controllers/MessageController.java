package com.project.controllers;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.model.Message;
import com.project.model.User;
import com.project.service.MessageService;

@Controller
public class MessageController {
	@Autowired
	@Qualifier(value="messageSer")
	private MessageService msgSer;
	private Logger logger = Logger.getLogger(MessageController.class);
	
	@RequestMapping(value="/message",produces="application/json" )
	@ResponseBody
	public Map<String,Object> get(Principal principal){
		List<Message> msgList = msgSer.getAllMessages();
		Map<String,Object> msgMap = new HashMap<String, Object>();
		msgMap.put("name", principal.getName());
		msgMap.put("msg", msgList);
		msgMap.put("totalcount", msgList.size());
		logger.debug("Showing messages");
		return msgMap;
	}
	@RequestMapping("/showSendMsgPage")
	public String showMsgPage( Model model){
		Message msg = new Message();
		model.addAttribute("message", msg);
		return "sendMessage";
	}
	@RequestMapping(value="/sendMessageToAdmin", method=RequestMethod.POST)
	public String saveMessagetoDB( @Valid Message msg,Model model, Principal principal, BindingResult result){
		System.out.println("errors ");
		if(!result.hasErrors()){
			msg.getFromUser().setUsername(principal.getName());
			int id = msgSer.saveMessage(msg);
			model.addAttribute("id", id);
			return "MessageSent";
		}
		return "sendMessage";
	}
	@RequestMapping("/showAllMessagesFromUser")
	public String showMessagesFromUser( Principal principal, Model model){
		List<Message> msgList = msgSer.getFromMessages(principal.getName());
		model.addAttribute("msgList", msgList);
		logger.debug("messgaes: " + msgList);
		
		return "ShowSentMsgView";
	}
	@RequestMapping("/showAllMessagesToAdmin")
	public String showMessagesToAdmin( Principal principal, Model model){
		List<Message> msgList = msgSer.getAllMessages();
		model.addAttribute("msgList", msgList);
		logger.debug("messgaes: " + msgList);
		
		return "ReceivedMessages";
	}
}
