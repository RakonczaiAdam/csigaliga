package hu.dreamteam.snailleague.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Comparable<User> {

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Columns
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "money_amount", nullable = false)
    private Integer moneyAmount;

    // From Snail Table
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Snail> snails;

    // From UserMatch Table
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserMatch> userMatches;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(Integer moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public List<Snail> getSnails() {
        return snails;
    }

    public void setSnails(List<Snail> snails) {
        this.snails = snails;
    }

    public Set<UserMatch> getUserMatches() {
        return userMatches;
    }

    public void setUserMatches(Set<UserMatch> userMatches) {
        this.userMatches = userMatches;
    }

    @Override
    public int compareTo(User user) {
        return this.moneyAmount.compareTo(user.getMoneyAmount());
    }
}
