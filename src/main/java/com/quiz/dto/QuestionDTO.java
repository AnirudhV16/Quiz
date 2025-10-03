package com.quiz.dto;

import java.util.Map;

public class QuestionDTO {
    private Long id;
    private String questionText;
    private Map<String, String> options;
    
    public QuestionDTO() {
    }
    
    public QuestionDTO(Long id, String questionText, Map<String, String> options) {
        this.id = id;
        this.questionText = questionText;
        this.options = options;
    }
    
    public QuestionDTO(Long id, String questionText, String optionA, 
                       String optionB, String optionC, String optionD) {
        this.id = id;
        this.questionText = questionText;
        this.options = Map.of(
            "A", optionA,
            "B", optionB,
            "C", optionC,
            "D", optionD
        );
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getQuestionText() {
        return questionText;
    }
    
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
    
    public Map<String, String> getOptions() {
        return options;
    }
    
    public void setOptions(Map<String, String> options) {
        this.options = options;
    }
}