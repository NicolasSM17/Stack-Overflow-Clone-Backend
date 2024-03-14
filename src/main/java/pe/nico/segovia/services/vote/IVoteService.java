package pe.nico.segovia.services.vote;

import pe.nico.segovia.dtos.QuestionVoteDTO;

public interface IVoteService {
    public QuestionVoteDTO addVoteToQuestion(QuestionVoteDTO questionVoteDTO);
}
