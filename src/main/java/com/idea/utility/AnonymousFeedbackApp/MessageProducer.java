package com.idea.utility.AnonymousFeedbackApp;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idea.utility.AnonymousFeedbackApp.beans.Feedback;

@RestController
@RequestMapping("/rest/producer")
public class MessageProducer {
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Autowired
	Queue queue;
	
	
	@PostMapping(path = "/feedback", consumes = "application/json", produces = "application/json")
	public @ResponseBody String sendMessage(@RequestBody String feedback) {
		
		try {
			jmsTemplate.convertAndSend(queue, feedback);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return feedback;
		
		
	}
	
	@PostMapping(path="/feedbackEntry")
	public @ResponseBody String sendMessage(@ModelAttribute(value="formFeedback") Feedback feedback) {
		
		String result="error";
		
		try {
			jmsTemplate.convertAndSend(queue, feedback);
			result="success";
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	

}
