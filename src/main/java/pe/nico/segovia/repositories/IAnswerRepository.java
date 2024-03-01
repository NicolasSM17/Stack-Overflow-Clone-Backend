package pe.nico.segovia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nico.segovia.entities.Answer;

import java.util.List;

@Repository
public interface IAnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findAllByQuestionId(Long questionId);
}
