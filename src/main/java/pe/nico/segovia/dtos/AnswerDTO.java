package pe.nico.segovia.dtos;

import lombok.Data;
import pe.nico.segovia.entities.Image;

import java.util.Date;

@Data
public class AnswerDTO {
    private Long id;
    private String body;
    private Date createdDate;
    private Long questionId;
    private Long userId;
    private String username;
    private Image file;
}
