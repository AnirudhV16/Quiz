package com.quiz.service;

import com.quiz.dto.*;
import com.quiz.entity.Question;
import com.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class QuizService {
    
    @Autowired
    private QuestionRepository questionRepository;
    
    //Get all questions for a quiz WITHOUT correct answers
    public List<QuestionDTO> getAllQuestions(Long quizId) {
        List<Question> questions = questionRepository.findByQuizId(quizId);
        
        return questions.stream()
                .map(q -> new QuestionDTO(
                        q.getId(),
                        q.getQuestionText(),
                        q.getOptionA(),
                        q.getOptionB(),
                        q.getOptionC(),
                        q.getOptionD()
                ))
                .collect(Collectors.toList());
    }
    
    
    //Calculate score and return detailed results
    public QuizResultDTO submitQuiz(Long quizId, Map<Long, String> userAnswers) {
        List<Question> questions = questionRepository.findByQuizId(quizId);
        
        int correctCount = 0;
        List<QuestionResultDTO> results = new ArrayList<>();
        
        for (Question question : questions) {
            String userAnswer = userAnswers.getOrDefault(question.getId(), null);
            String correctAnswer = question.getCorrectOption();
            
            boolean isCorrect = correctAnswer.equalsIgnoreCase(userAnswer);
            if (isCorrect) {
                correctCount++;
            }
            
            // Create detailed result for this question
            QuestionResultDTO resultDTO = new QuestionResultDTO(
                    question.getId(),
                    question.getQuestionText(),
                    userAnswer,
                    correctAnswer,
                    isCorrect
            );
            results.add(resultDTO);
        }
        
        int totalQuestions = questions.size();
        double score = totalQuestions > 0 
                ? (double) correctCount / totalQuestions * 100 
                : 0.0;
        
        return new QuizResultDTO(
                totalQuestions,
                correctCount,
                Math.round(score * 100.0) / 100.0,
                results
        );
    }
}