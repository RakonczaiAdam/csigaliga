package hu.dreamteam.snailleague.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "matches")
public class Match {

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Columns
    @Column(name = "match_date", nullable = false)
    private Date matchDate;

    @Column(name = "status", nullable = false)
    private String status;

    // From Maps Table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mapId", nullable = false)
    private Map mapId;

    // From SnailMatch Table
    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<SnailMatch> snailMatches;

    // From UserMatch Table
    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserMatch> userMatches;

    // Getters, Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Set<SnailMatch> getSnailMatches() {
        return snailMatches;
    }

    public void setSnailMatches(Set<SnailMatch> snailMatches) {
        this.snailMatches = snailMatches;
    }

    public Set<UserMatch> getUserMatches() {
        return userMatches;
    }

    public void setUserMatches(Set<UserMatch> userMatches) {
        this.userMatches = userMatches;
    }
}
