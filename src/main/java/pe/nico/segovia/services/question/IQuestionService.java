package pe.nico.segovia.services.question;

import pe.nico.segovia.dtos.QuestionDTO;

public interface IQuestionService {
    QuestionDTO addQuestion(QuestionDTO questionDTO);
}
