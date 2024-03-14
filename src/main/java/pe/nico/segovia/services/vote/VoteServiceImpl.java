package pe.nico.segovia.services.vote;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.nico.segovia.dtos.QuestionVoteDTO;
import pe.nico.segovia.entities.Question;
import pe.nico.segovia.entities.QuestionVote;
import pe.nico.segovia.entities.UserEntity;
import pe.nico.segovia.repositories.IQuestionRepository;
import pe.nico.segovia.repositories.IQuestionVoteRepository;
import pe.nico.segovia.repositories.IUserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements IVoteService{
    private final IQuestionVoteRepository questionVoteRepository;
    private final IUserRepository userRepository;
    private final IQuestionRepository questionRepository;

    @Override
    public QuestionVoteDTO addVoteToQuestion(QuestionVoteDTO questionVoteDTO) {
        Optional<UserEntity> optionalUser = userRepository.findById(questionVoteDTO.getUserId());
        Optional<Question> optionalQuestion = questionRepository.findById(questionVoteDTO.getQuestionId());

        if(optionalQuestion.isPresent() && optionalUser.isPresent()){
            QuestionVote questionVote = new QuestionVote();
            questionVote.setVoteType(questionVoteDTO.getVoteType());
            questionVote.setQuestion(optionalQuestion.get());
            questionVote.setUser(optionalUser.get());

            QuestionVote votedQuestion = questionVoteRepository.save(questionVote);
            QuestionVoteDTO questionVotedDTO = new QuestionVoteDTO();
            questionVotedDTO.setId(votedQuestion.getId());

            return questionVotedDTO;
        }

        return null;
    }
}
