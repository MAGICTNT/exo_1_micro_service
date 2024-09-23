package fr.maxime.exo_01_micro_service.repository;

import fr.maxime.exo_01_micro_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
}
