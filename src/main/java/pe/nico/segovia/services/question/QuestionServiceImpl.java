package pe.nico.segovia.services.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.nico.segovia.dtos.AllQuestionResponseDTO;
import pe.nico.segovia.dtos.QuestionDTO;
import pe.nico.segovia.entities.Question;
import pe.nico.segovia.entities.UserEntity;
import pe.nico.segovia.repositories.IQuestionRepository;
import pe.nico.segovia.repositories.IUserRepository;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements IQuestionService{

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IQuestionRepository questionRepository;

    public static final int SEARCH_RESULT_PER_PAGE = 5;

    @Override
    public QuestionDTO addQuestion(QuestionDTO questionDTO) {
        Optional<UserEntity> optionalUser = userRepository.findById(questionDTO.getUserId());

        if(optionalUser.isPresent()){
            Question question = new Question();
            question.setTitle(questionDTO.getTitle());
            question.setBody(questionDTO.getBody());
            question.setTags(questionDTO.getTags());
            question.setCreatedDate(new Date());
            question.setUser(optionalUser.get());

            Question createdQuestion = questionRepository.save(question);
            QuestionDTO createdQuestionDto = new QuestionDTO();
            createdQuestionDto.setId(createdQuestion.getId());
            createdQuestionDto.setTitle(createdQuestion.getTitle());

            return createdQuestionDto;
        }

        return null;
    }

    @Override
    public AllQuestionResponseDTO getAllQuestions(int pageNumber) {
        Pageable paging = PageRequest.of(pageNumber, SEARCH_RESULT_PER_PAGE);
        Page<Question> questionPage = questionRepository.findAll(paging);
        AllQuestionResponseDTO allQuestionResponseDTO = new AllQuestionResponseDTO();

        allQuestionResponseDTO.setQuestionDTOList(questionPage.getContent().stream().map(Question::getQuestionDTO).collect(Collectors.toList()));
        allQuestionResponseDTO.setPageNumber(questionPage.getPageable().getPageNumber());
        allQuestionResponseDTO.setTotalPages(questionPage.getTotalPages());

        return allQuestionResponseDTO;
    }
}
