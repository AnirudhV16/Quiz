package com.quiz.dto;

import java.util.List;

public class QuizResultDTO {
    private int totalQuestions;
    private int correctAnswers;
    private double score;
    private List<QuestionResultDTO> results;
    
    public QuizResultDTO() {
    	super();
    }
    
    public QuizResultDTO(int totalQuestions, int correctAnswers, 
                         double score, List<QuestionResultDTO> results) {
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.score = score;
        this.results = results;
    }
    
    public int getTotalQuestions() {
        return totalQuestions;
    }
    
    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }
    
    public int getCorrectAnswers() {
        return correctAnswers;
    }
    
    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }
    
    public double getScore() {
        return score;
    }
    
    public void setScore(double score) {
        this.score = score;
    }
    
    public List<QuestionResultDTO> getResults() {
        return results;
    }
    
    public void setResults(List<QuestionResultDTO> results) {
        this.results = results;
    }
}