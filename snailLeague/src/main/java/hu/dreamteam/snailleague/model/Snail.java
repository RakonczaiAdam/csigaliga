package hu.dreamteam.snailleague.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "snails")
public class Snail {

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Columns
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "speed", nullable = false)
    private Integer speed;

    @Column(name = "stamina", nullable = false)
    private Integer stamina;

    // From Users Table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User userId;

    // From Skins Table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skinId", nullable = false)
    private Skin skinId;

    // From SnailMatch Table
    @OneToMany(mappedBy = "snail")
    private Set<SnailMatch> snailMatches;

    // Constructor
    public Snail() {

    }

    public Snail(String name, Integer speed, Integer stamina) {
        this.name = name;
        this.speed = speed;
        this.stamina = stamina;
    }

    // Getters, Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getStamina() {
        return stamina;
    }

    public void setStamina(Integer stamina) {
        this.stamina = stamina;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Skin getSkinId() {
        return skinId;
    }

    public void setSkinId(Skin skinId) {
        this.skinId = skinId;
    }

    public Set<SnailMatch> getSnailMatches() {
        return snailMatches;
    }

    public void setSnailMatches(Set<SnailMatch> snailMatches) {
        this.snailMatches = snailMatches;
    }
}
