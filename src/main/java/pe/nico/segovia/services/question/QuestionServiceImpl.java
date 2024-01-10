package pe.nico.segovia.services.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.nico.segovia.dtos.QuestionDTO;
import pe.nico.segovia.entities.Question;
import pe.nico.segovia.entities.UserEntity;
import pe.nico.segovia.repositories.IQuestionRepository;
import pe.nico.segovia.repositories.IUserRepository;

import java.util.Date;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements IQuestionService{

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IQuestionRepository questionRepository;

    @Override
    public QuestionDTO addQuestion(QuestionDTO questionDTO) {
        Optional<UserEntity> optionalUser = userRepository.findById(questionDTO.getUserId());

        if(optionalUser.isPresent()){
            Question question = new Question();
            question.setTitle(questionDTO.getTitle());
            question.setBody(questionDTO.getBody());
            question.setTags(questionDTO.getTags());
            question.setCreatedDate(new Date());

            Question createdQuestion = questionRepository.save(question);
            QuestionDTO createdQuestionDto = new QuestionDTO();
            createdQuestionDto.setId(createdQuestion.getId());
            createdQuestionDto.setTitle(createdQuestion.getTitle());

            return createdQuestionDto;
        }

        return null;
    }
}
