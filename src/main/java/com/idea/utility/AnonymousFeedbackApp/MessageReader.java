package com.idea.utility.AnonymousFeedbackApp;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.jms.JMSException;
//import javax.jms.Message;
import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.BrowserCallback;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import com.google.common.collect.Lists;

import javax.jms.QueueBrowser;
import javax.jms.Session;

@RestController
@RequestMapping("/rest/reader")
public class MessageReader {
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Autowired
	Queue queue;
	
	@GetMapping(path = "/getFeedbacks", produces = "application/json")
	public @ResponseBody List<String> getMessages() {
		
		List<String> feedbacks = new ArrayList<String>();
		int total = jmsTemplate.browse(queue, new BrowserCallback<Integer>() {

			@Override
			public Integer doInJms(Session session, QueueBrowser browser) throws JMSException {
				Enumeration enumeration = browser.getEnumeration();
				int counter = 0;
				
				while (enumeration.hasMoreElements()) {
					ActiveMQTextMessage message = (ActiveMQTextMessage)enumeration.nextElement();
					//System.out.println("***** "+message.getText());
					feedbacks.add(message.getText());
					counter +=1 ;
				}
				
				return counter;
			}
			
		});	
		//System.out.println("-----"+total);
		return feedbacks;
	}
	
	

}
