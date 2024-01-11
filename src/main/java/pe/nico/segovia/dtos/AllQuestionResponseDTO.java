package pe.nico.segovia.dtos;

import lombok.Data;

import java.util.List;

@Data
public class AllQuestionResponseDTO {
    private List<QuestionDTO> questionDTOList;
    private Integer totalPages;
    private Integer pageNumber;
}
