package pe.nico.segovia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nico.segovia.entities.Answer;
import pe.nico.segovia.entities.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    Image findByAnswer(Answer answer);
}
