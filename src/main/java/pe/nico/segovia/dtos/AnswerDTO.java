package pe.nico.segovia.dtos;

import lombok.Data;

@Data
public class AnswerDTO {
    private Long id;
    private String body;
    private Long questionId;
    private Long userId;
}
