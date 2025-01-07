package com.karan.QuizApp.service;

import com.karan.QuizApp.DAO.QuestionRepo;
import com.karan.QuizApp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepo questionRepo;

    public ResponseEntity<List<Question>> getQuestions() {
        try {
            return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> addQuestions(List<Question> questions) {
        try {
            questionRepo.saveAll(questions);
            return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
         return new ResponseEntity<>("Not Added",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionRepo.findByCategory(category), HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            return new ResponseEntity<>("Successfully added question", HttpStatus.CREATED);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Question Not added ", HttpStatus.BAD_REQUEST);
    }
}
