package hu.dreamteam.snailleague.model;

import javax.persistence.*;

@Entity
@IdClass(SnailMatch.class)
public class SnailMatch implements java.io.Serializable {

    // Foreign IDs
    @Id
    @ManyToOne
    private Snail snail;

    @Id
    @ManyToOne
    private Match match;

    // Columns
    @Column(name = "place", nullable = false)
    private Integer place;

    // Getters, Setters
    public Snail getSnail() {
        return snail;
    }

    public void setSnail(Snail snail) {
        this.snail = snail;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }
}
