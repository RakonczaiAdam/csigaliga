package hu.dreamteam.snailleague.repository;

import hu.dreamteam.snailleague.model.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapRepository extends JpaRepository<Map, Long> {

}