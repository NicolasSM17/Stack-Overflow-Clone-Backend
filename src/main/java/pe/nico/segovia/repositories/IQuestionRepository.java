package pe.nico.segovia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nico.segovia.entities.Question;

@Repository
public interface IQuestionRepository extends JpaRepository<Question, Long> {
}
