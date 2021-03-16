package hu.dreamteam.snailleague.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "snail_match")
public class SnailMatch {

    // Columns
    @Column(name = "place")
    private Integer place;

    // From Snails Table

    // From Matches Table
}
