package guru.springframework.springmvcrest.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Pack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    private List<Wolf> wolves = new ArrayList<>();

    public List<Wolf> findAllWolves() {
        return wolves;
    }
}
