package com.quiz.controller;

import com.quiz.dto.QuestionDTO;
import com.quiz.dto.QuizResultDTO;
import com.quiz.dto.SubmitQuizRequest;
import com.quiz.service.QuizService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"})
public class QuizController {
    
    @Autowired
    private QuizService quizService;
    
    //GET /api/quiz/questions
    //Fetch all questions (without correct answers)
    @GetMapping("/questions")
    public ResponseEntity<List<QuestionDTO>> getQuestions() {
        Long quizId = 1L; // Using quiz ID 1 for simplicity
        List<QuestionDTO> questions = quizService.getAllQuestions(quizId);
        return ResponseEntity.ok(questions);
    }
    
    //POST /api/quiz/submit
    //Submit quiz answers and get results
    @PostMapping("/submit")
    public ResponseEntity<QuizResultDTO> submitQuiz(
            @Valid @RequestBody SubmitQuizRequest request) {
        Long quizId = 1L;
        QuizResultDTO result = quizService.submitQuiz(quizId, request.getAnswers());
        return ResponseEntity.ok(result);
    }
}