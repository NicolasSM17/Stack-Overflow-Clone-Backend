package pe.nico.segovia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.nico.segovia.dtos.QuestionDTO;
import pe.nico.segovia.services.question.IQuestionService;

@RestController
@RequestMapping("/api")
public class QuestionController {

    @Autowired
    private IQuestionService questionService;

    @PostMapping("/question")
    public ResponseEntity<?> postQuestion(@RequestBody QuestionDTO questionDTO){
        QuestionDTO createdQuestionDto = questionService.addQuestion(questionDTO);

        if(createdQuestionDto == null){
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuestionDto);
    }
}
