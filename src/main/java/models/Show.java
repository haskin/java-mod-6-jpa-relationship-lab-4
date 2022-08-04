package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Shows")
@Getter
@Setter
@NoArgsConstructor
public class Show {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String dayOfTheWeek;
    private String season;
    private String genre;
    @OneToMany(mappedBy = "show")
    private List<Character> characters;
    @ManyToOne(fetch = FetchType.LAZY)
    private Network network;

    public Show(String name, String day, String season, String genre, Network network) {
        this.name = name;
        this.dayOfTheWeek = day;
        this.season = season;
        this.genre = genre;
        this.network = network;
    }
}
