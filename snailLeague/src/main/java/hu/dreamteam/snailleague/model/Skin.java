package hu.dreamteam.snailleague.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "skins")
public class Skin {

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Columns
    @Column(name = "color", nullable = false)
    private String color;

    // From Snail Table
    @OneToMany(mappedBy = "skinId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Snail> snails;

    // Getters, Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Snail> getSnails() {
        return snails;
    }

    public void setSnails(List<Snail> snails) {
        this.snails = snails;
    }
}
