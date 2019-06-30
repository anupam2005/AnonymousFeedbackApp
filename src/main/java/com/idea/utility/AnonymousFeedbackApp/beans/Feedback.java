package com.idea.utility.AnonymousFeedbackApp.beans;

import java.io.Serializable;

public class Feedback implements Serializable{
	
	private static final long serialVersionUID = 8214563870517795271L;
	
	
	private String goingGood;
	public String getGoingGood() {
		return goingGood;
	}
	public void setGoingGood(String goingGood) {
		this.goingGood = goingGood;
	}
	private String needsImprovement;
	
	public String getNeedsImprovement() {
		return needsImprovement;
	}
	public void setNeedsImprovement(String needsImprovement) {
		this.needsImprovement = needsImprovement;
	}
	
	

}
