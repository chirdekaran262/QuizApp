package com.karan.QuizApp.service;

import com.karan.QuizApp.DAO.QuestionRepo;
import com.karan.QuizApp.DAO.QuizRepo;
import com.karan.QuizApp.model.Question;
import com.karan.QuizApp.model.QuestionWrapper;
import com.karan.QuizApp.model.Quiz;
import com.karan.QuizApp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    private QuestionRepo questionrepo;
    @Autowired
    private QuizRepo quizRepo;

    public ResponseEntity<String> createQuize(String category, int numQ, String title) {
        List<Question> question=questionrepo.findRandomQuestionByCategory(category,numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(question);
        quizRepo.save(quiz);

        return new ResponseEntity<>("Quiz created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        Optional<Quiz> quiz=quizRepo.findById(id);
        List<Question> questionFromDB=quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser=new ArrayList<>();
        for(Question q:questionFromDB){
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionForUser.add(qw);
        }
        return new ResponseEntity<>(questionForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(int id, List<Response> response) {
        Quiz quiz=quizRepo.findById(id).get();
        List<Question> questions=quiz.getQuestions();
        int right=0;
        int i=0;
        for(Response r:response){
            if(r.getResponse().equals(questions.get(i).getRightAnswer())){
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
