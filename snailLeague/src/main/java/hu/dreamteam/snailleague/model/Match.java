package hu.dreamteam.snailleague.model;

import javax.persistence.*;
import java.util.Date;

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
}
