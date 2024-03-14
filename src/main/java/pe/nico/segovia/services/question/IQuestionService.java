package pe.nico.segovia.services.question;

import pe.nico.segovia.dtos.AllQuestionResponseDTO;
import pe.nico.segovia.dtos.QuestionDTO;
import pe.nico.segovia.dtos.SingleQuestionDTO;

public interface IQuestionService {
    QuestionDTO addQuestion(QuestionDTO questionDTO);
    AllQuestionResponseDTO getAllQuestions(int pageNumber);
    SingleQuestionDTO getQuestionById(Long questionId);
    AllQuestionResponseDTO getQuestionByUserId(Long userId, int pageNumber);
}
