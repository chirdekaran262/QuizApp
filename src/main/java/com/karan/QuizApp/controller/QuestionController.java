package com.karan.QuizApp.controller;


import com.karan.QuizApp.model.Question;
import com.karan.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;


    @GetMapping("getQuestions")
    public ResponseEntity<List<Question>> getQuestions() {
        return questionService.getQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        System.out.println(questionService.getQuestionsByCategory(category));
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("addQuestions")
    public ResponseEntity<String> addQuestions(@RequestBody List<Question> questions) {
        return questionService.addQuestions(questions);
    }

    @PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }
}
