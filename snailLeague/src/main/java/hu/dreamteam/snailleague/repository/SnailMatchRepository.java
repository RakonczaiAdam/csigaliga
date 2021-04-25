package hu.dreamteam.snailleague.repository;

import hu.dreamteam.snailleague.model.SnailMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnailMatchRepository extends JpaRepository<SnailMatch, Long> {

}

