package pe.nico.segovia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import pe.nico.segovia.dtos.AnswerDTO;

import java.util.Date;

@Entity
@Getter
@Setter
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "body", length = 512)
    private String body;

    private Date createdDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Question question;

    public AnswerDTO getAnswerDto(){
        AnswerDTO answerDTO = new AnswerDTO();
        answerDTO.setId(id);
        answerDTO.setBody(body);
        answerDTO.setCreatedDate(createdDate);
        answerDTO.setUserId(user.getId());
        answerDTO.setUsername(user.getName());
        answerDTO.setQuestionId(question.getId());

        return answerDTO;
    }
}
