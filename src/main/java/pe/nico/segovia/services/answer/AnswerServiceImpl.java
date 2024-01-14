package pe.nico.segovia.services.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.nico.segovia.dtos.AnswerDTO;
import pe.nico.segovia.entities.Answer;
import pe.nico.segovia.entities.Question;
import pe.nico.segovia.entities.UserEntity;
import pe.nico.segovia.repositories.IAnswerRepository;
import pe.nico.segovia.repositories.IQuestionRepository;
import pe.nico.segovia.repositories.IUserRepository;

import java.util.Date;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements IAnswerService{

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IQuestionRepository questionRepository;

    @Autowired
    private IAnswerRepository answerRepository;

    @Override
    public AnswerDTO postAnswer(AnswerDTO answerDTO) {
        Optional<UserEntity> optionalUser = userRepository.findById(answerDTO.getUserId());
        Optional<Question> optionalQuestion = questionRepository.findById(answerDTO.getQuestionId());

        if(optionalUser.isPresent() && optionalQuestion.isPresent()){
            Answer answer = new Answer();
            answer.setBody(answerDTO.getBody());
            answer.setCreatedDate(new Date());
            answer.setUser(optionalUser.get());
            answer.setQuestion(optionalQuestion.get());
            Answer createdAnswer = answerRepository.save(answer);

            AnswerDTO createdAnswerDto = new AnswerDTO();
            createdAnswerDto.setId(createdAnswer.getId());

            return createdAnswerDto;
        }

        return null;
    }
}
