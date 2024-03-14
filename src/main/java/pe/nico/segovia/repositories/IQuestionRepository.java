package pe.nico.segovia.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nico.segovia.entities.Question;

@Repository
public interface IQuestionRepository extends JpaRepository<Question, Long> {
    Page<Question> findAllByUserId(Long userId, Pageable paging);
}
