package pe.nico.segovia.dtos;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String body;
    private List<String> tags;
    private Date createdDate;
    private Long userId;
    private String username;
}
