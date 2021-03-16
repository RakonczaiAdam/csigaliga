package hu.dreamteam.snailleague.repository;

import hu.dreamteam.snailleague.model.Snail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnailRepository extends JpaRepository<Snail, Long> {

}
