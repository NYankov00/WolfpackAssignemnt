package guru.springframework.springmvcrest.services;

import guru.springframework.springmvcrest.domain.Wolf;
import org.apache.coyote.Response;

import java.util.List;

public interface WolfService {
    Wolf findWolfById(Long id);

    List<Wolf> findAllWolves();

    Wolf saveWolf(Wolf wolf);

    boolean updateWolfLocation(Wolf wolf);

    void deleteWolf(Wolf wolf);
}
