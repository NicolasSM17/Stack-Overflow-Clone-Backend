package pe.nico.segovia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nico.segovia.entities.QuestionVote;

@Repository
public interface IQuestionVoteRepository extends JpaRepository<QuestionVote, Long> {
}
