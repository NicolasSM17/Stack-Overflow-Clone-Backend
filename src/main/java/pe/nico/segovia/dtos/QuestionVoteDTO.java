package pe.nico.segovia.dtos;

import lombok.Data;
import pe.nico.segovia.enums.VoteType;

@Data
public class QuestionVoteDTO {
    private Long id;
    private VoteType voteType;
    private Long userId;
    private Long questionId;
}
