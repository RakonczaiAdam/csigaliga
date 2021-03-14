package hu.dreamteam.snailleague.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "money")
    private Integer money;

    @Column(name = "successful_bets")
    private Integer successfulBets;

    public User() {

    }

    public User(String username, Integer money, Integer successfulBets) {
        this.username = username;
        this.money = money;
        this.successfulBets = successfulBets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getSuccessfulBets() {
        return successfulBets;
    }

    public void setSuccessfulBets(Integer successfulBets) {
        this.successfulBets = successfulBets;
    }
}
