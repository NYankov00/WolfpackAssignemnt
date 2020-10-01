package guru.springframework.springmvcrest.repositories;

import guru.springframework.springmvcrest.domain.Wolf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WolfRepository extends JpaRepository<Wolf, Long> {
}
