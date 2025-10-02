package com.quiz.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 500)
    private String questionText;
    
    @Column(nullable = false, length = 200)
    private String optionA;
    
    @Column(nullable = false, length = 200)
    private String optionB;
    
    @Column(nullable = false, length = 200)
    private String optionC;
    
    @Column(nullable = false, length = 200)
    private String optionD;
    
    @Column(nullable = false, length = 1)
    private String correctOption; // 'A', 'B', 'C', or 'D'
    
    @Column(nullable = false)
    private Long quizId;

	public Long getId() {
		return id;
	}

	public Question() {
		super();
	}

	public Question(Long id, String questionText, String optionA, String optionB, String optionC, String optionD,
			String correctOption, Long quizId) {
		super();
		this.id = id;
		this.questionText = questionText;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.correctOption = correctOption;
		this.quizId = quizId;
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

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}
    
    
}