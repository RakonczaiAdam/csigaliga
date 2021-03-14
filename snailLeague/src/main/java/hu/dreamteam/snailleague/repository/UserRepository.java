package hu.dreamteam.snailleague.repository;

import hu.dreamteam.snailleague.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
