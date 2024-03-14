package pe.nico.segovia.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.nico.segovia.dtos.QuestionVoteDTO;
import pe.nico.segovia.services.vote.IVoteService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class VoteController {
    private final IVoteService voteService;

    @PostMapping("/vote")
    public ResponseEntity<?> addVoteToQuestion(@RequestBody QuestionVoteDTO questionVoteDTO){
        QuestionVoteDTO questionVotedDTO = voteService.addVoteToQuestion(questionVoteDTO);

        if(questionVotedDTO == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(questionVotedDTO);
    }
}
