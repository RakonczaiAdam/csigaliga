package hu.dreamteam.snailleague.repository;

import hu.dreamteam.snailleague.model.UserMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMatchRepository extends JpaRepository<UserMatch, Long> {

}

