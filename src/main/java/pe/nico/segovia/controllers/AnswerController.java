package pe.nico.segovia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.nico.segovia.dtos.AnswerDTO;
import pe.nico.segovia.services.answer.IAnswerService;

@RestController
@RequestMapping("/api")
public class AnswerController {

    @Autowired
    private IAnswerService answerService;

    @PostMapping("/answer")
    public ResponseEntity<?> addAnswer(@RequestBody AnswerDTO answerDTO){
        AnswerDTO createdAnswerDto = answerService.postAnswer(answerDTO);

        if(createdAnswerDto == null){
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnswerDto);
    }
}
