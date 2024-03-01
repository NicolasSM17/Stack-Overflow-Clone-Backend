package pe.nico.segovia.dtos;

import lombok.Data;

import java.util.List;

@Data
public class SingleQuestionDTO {
    private QuestionDTO questionDto;
    private List<AnswerDTO> answerDTOList;
}
