package hu.dreamteam.snailleague.model;

import javax.persistence.*;

@Entity
@Table(name = "snail")
public class Snail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "speed", nullable = false)
    private Integer speed;

    @Column(name = "stamina", nullable = false)
    private Integer stamina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="userId", nullable=false)
    private User userId;

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
}
