package hu.dreamteam.snailleague.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "matches")
public class Match {

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Columns
    @Column(name = "won", nullable = false)
    private Boolean won;

    @Column(name = "money_set", nullable = false)
    private Integer moneySet;

    @Column(name = "match_date", nullable = false)
    private Date matchDate;

    // From Maps Table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mapId", nullable = false)
    private Map mapId;

    // From Users Table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User userId;

    // From SnailMatch Table
    @OneToMany(mappedBy = "match")
    private Set<SnailMatch> snailMatches;

    // Getters, Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getWon() {
        return won;
    }

    public void setWon(Boolean won) {
        this.won = won;
    }

    public Integer getMoneySet() {
        return moneySet;
    }

    public void setMoneySet(Integer moneySet) {
        this.moneySet = moneySet;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public Map getMapId() {
        return mapId;
    }

    public void setMapId(Map mapId) {
        this.mapId = mapId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Set<SnailMatch> getSnailMatches() {
        return snailMatches;
    }

    public void setSnailMatches(Set<SnailMatch> snailMatches) {
        this.snailMatches = snailMatches;
    }
}
