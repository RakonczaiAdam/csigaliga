package hu.dreamteam.snailleague.model;

import javax.persistence.*;

@Entity
@IdClass(UserMatch.class)
public class UserMatch implements java.io.Serializable {

    // Foreign IDs
    @Id
    @ManyToOne
    private User user;

    @Id
    @ManyToOne
    private Match match;

    // Columns
    @Column(name = "money_set")
    private Integer moneySet;

    @Column(name = "won")
    private Boolean won;

    // From Snail Table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "snailId", nullable = false)
    private Snail snailId;

    private UserMatch(){}

    public UserMatch(User user, Match match){
        this.user = user;
        this.match = match;
    }

    // Getters, Setters

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Integer getMoneySet() {
        return moneySet;
    }

    public void setMoneySet(Integer moneySet) {
        this.moneySet = moneySet;
    }

    public Boolean getWon() {
        return won;
    }

    public void setWon(Boolean won) {
        this.won = won;
    }

    public Snail getSnailId() {
        return snailId;
    }

    public void setSnailId(Snail snailId) {
        this.snailId = snailId;
    }
}
