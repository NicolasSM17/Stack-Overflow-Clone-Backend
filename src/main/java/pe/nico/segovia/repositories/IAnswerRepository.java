package pe.nico.segovia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nico.segovia.entities.Answer;

@Repository
public interface IAnswerRepository extends JpaRepository<Answer, Long> {
}
