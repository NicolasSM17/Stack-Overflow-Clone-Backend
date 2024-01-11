package pe.nico.segovia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import pe.nico.segovia.dtos.QuestionDTO;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    @Column(name = "body", length = 512)
    private String body;

    private Date createdDate;

    @ElementCollection(targetClass = String.class)
    private List<String> tags;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private UserEntity user;

    public QuestionDTO getQuestionDTO(){
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(id);
        questionDTO.setTitle(title);
        questionDTO.setBody(body);
        questionDTO.setTags(tags);
        questionDTO.setUserId(user.getId());
        questionDTO.setUsername(user.getName());

        return questionDTO;
    }
}
