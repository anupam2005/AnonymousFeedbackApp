package com.idea.utility.AnonymousFeedbackApp;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.idea.utility.AnonymousFeedbackApp.beans.Feedback;
import com.idea.utility.AnonymousFeedbackApp.util.JsonTransform;

@Controller
@RequestMapping("/feedbackApp")
public class GUIController {
	
	public static final String SUCCESS="Anonymous feedback sumbitted successfully \n Thank you!";
	public static final String ERROR="Sorry somethigns worng, poke the developer ;)";
	public static final String ADD_FEEDBACK_URL="http://localhost:8081/rest/producer/feedback";
	
	
	@GetMapping("/survey")
	public String showForm(Model model) {
		
		Feedback formFeedback = new Feedback();
		//formFeedback.setGoingGood("Write what's going good here...");
		//formFeedback.setNeedsImprovement("Write what's the improvement you would like to see...");
		model.addAttribute("formFeedback", formFeedback);
		
		return "input";
		
	}
	
	@PostMapping("/save")
	public @ResponseBody String saveFeedBack(@ModelAttribute Feedback formFeedback) {
		
		String result=ERROR;
		
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
	    headers.setContentType(MediaType.APPLICATION_JSON);
		
		//System.out.println("======="+JsonTransform.java2json(formFeedback));
		
		HttpEntity<Feedback> requestBody = new HttpEntity<>(formFeedback, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Feedback> f = restTemplate.postForEntity(ADD_FEEDBACK_URL, requestBody, Feedback.class);
		
	    if(f.getStatusCode() == HttpStatus.OK) {
	    	
	    	result=SUCCESS;
	    }
		
		return result;
		
	}

}
