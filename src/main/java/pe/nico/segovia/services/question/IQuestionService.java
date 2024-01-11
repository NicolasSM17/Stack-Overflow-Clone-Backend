package pe.nico.segovia.services.question;

import pe.nico.segovia.dtos.AllQuestionResponseDTO;
import pe.nico.segovia.dtos.QuestionDTO;

public interface IQuestionService {
    QuestionDTO addQuestion(QuestionDTO questionDTO);
    AllQuestionResponseDTO getAllQuestions(int pageNumber);
}
