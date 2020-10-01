package guru.springframework.springmvcrest.repositories;

import guru.springframework.springmvcrest.domain.Pack;
import guru.springframework.springmvcrest.domain.Wolf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackRepository extends JpaRepository<Pack, Long> {
    default List<Wolf> findAllWolvesForAPack(Pack pack) {
        return pack.findAllWolves();
    }
}


