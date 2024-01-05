package pe.nico.segovia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nico.segovia.entities.UserEntity;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

}
