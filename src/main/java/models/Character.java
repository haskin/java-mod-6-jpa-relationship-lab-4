package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Characters")
@Getter
@Setter
@NoArgsConstructor
public class Character {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String catchphrase;

    @ManyToOne(fetch = FetchType.LAZY)
    private Actor actor;
    @ManyToOne(fetch = FetchType.LAZY)
    private Show show;

    public Character(String name, String catchphrase, Actor actor, Show show) {
        this.name = name;
        this.catchphrase = catchphrase;
        this.actor = actor;
        this.show = show;
    }
}
