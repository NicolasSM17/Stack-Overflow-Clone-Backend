package pe.nico.segovia.services.answer;

import pe.nico.segovia.dtos.AnswerDTO;

public interface IAnswerService {
    AnswerDTO postAnswer(AnswerDTO answerDTO);
}
