package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Networks")
@Getter
@Setter
@NoArgsConstructor
public class Network {
    @Id
    @GeneratedValue
    private int id;
    private String callLetters;
    private int channel;
    @OneToMany(mappedBy = "network")
    private List<Show> shows;

    public Network(String callLetters, int channel) {
        this.callLetters = callLetters;
        this.channel = channel;
    }
}
