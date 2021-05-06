package hu.dreamteam.snailleague.repository;

import hu.dreamteam.snailleague.model.Skin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkinRepository extends JpaRepository<Skin, Long> {

}
