package pe.nico.segovia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.nico.segovia.dtos.AllQuestionResponseDTO;
import pe.nico.segovia.dtos.QuestionDTO;
import pe.nico.segovia.dtos.SingleQuestionDTO;
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

    @GetMapping("/questions/{pageNumber}")
    public ResponseEntity<AllQuestionResponseDTO> getAllQuestions(@PathVariable int pageNumber){
        AllQuestionResponseDTO allQuestionResponseDTO = questionService.getAllQuestions(pageNumber);

        return ResponseEntity.ok(allQuestionResponseDTO);
    }

    @GetMapping("/question/{questionId}")
    public ResponseEntity<?> getQuestionById(@PathVariable Long questionId){
        SingleQuestionDTO singleQuestionDto = questionService.getQuestionById(questionId);

        if(singleQuestionDto == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(singleQuestionDto);
    }

    @GetMapping("/questions/{userId}/{pageNumber}")
    public ResponseEntity<AllQuestionResponseDTO> getQuestionsByUserId(@PathVariable Long userId, @PathVariable int pageNumber){
        AllQuestionResponseDTO allQuestionResponseDTO = questionService.getQuestionByUserId(userId, pageNumber);

        return ResponseEntity.ok(allQuestionResponseDTO);
    }
}
