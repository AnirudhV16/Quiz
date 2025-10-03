package com.quiz.dto;

public class QuestionResultDTO {
    private Long questionId;
    private String questionText;
    private String userAnswer;
    private String correctAnswer;
    private boolean isCorrect;
    
    public QuestionResultDTO() {
    	super();
    }
    
    public QuestionResultDTO(Long questionId, String questionText, 
                             String userAnswer, String correctAnswer, boolean isCorrect) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.userAnswer = userAnswer;
        this.correctAnswer = correctAnswer;
        this.isCorrect = isCorrect;
    }
    
    public Long getQuestionId() {
        return questionId;
    }
    
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
    
    public String getQuestionText() {
        return questionText;
    }
    
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
    
    public String getUserAnswer() {
        return userAnswer;
    }
    
    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
    
    public String getCorrectAnswer() {
        return correctAnswer;
    }
    
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    
    public boolean isCorrect() {
        return isCorrect;
    }
    
    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}