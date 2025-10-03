package com.quiz.dto;

import jakarta.validation.constraints.NotNull;

import java.util.Map;

public class SubmitQuizRequest {
    
    @NotNull(message = "Answers cannot be null")
    private Map<Long, String> answers;
    
    
    public SubmitQuizRequest(Map<Long, String> answers) {
        this.answers = answers;
    }
    
    public SubmitQuizRequest() {
		super();
	}
    
    public Map<Long, String> getAnswers() {
        return answers;
    }

	public void setAnswers(Map<Long, String> answers) {
        this.answers = answers;
    }
}