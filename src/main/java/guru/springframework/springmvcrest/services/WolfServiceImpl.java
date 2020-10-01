package guru.springframework.springmvcrest.services;

import guru.springframework.springmvcrest.domain.Wolf;
import guru.springframework.springmvcrest.repositories.WolfRepository;
import org.apache.coyote.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WolfServiceImpl implements WolfService {
    private final WolfRepository wolfRepository;

    public WolfServiceImpl(WolfRepository wolfRepository) {
        this.wolfRepository = wolfRepository;
    }

    @Override
    public Wolf findWolfById(Long id) {
        return wolfRepository.findById(id).get();
    }

    @Override
    public List<Wolf> findAllWolves() {
        return wolfRepository.findAll();
    }

    @Override
    public Wolf saveWolf(Wolf wolf) {
        return wolfRepository.save(wolf);
    }

    @Override
    public boolean updateWolfLocation(Wolf wolf) {
        Wolf old = this.findWolfById(wolf.getId());
        if (old == null) {
            return false;
        } else {
            old.setLocation(wolf.getLocation());
            wolfRepository.save(wolf);
            return true;
        }
    }

    @Override
    public void deleteWolf(Wolf wolf) {
        Wolf old = this.findWolfById(wolf.getId());
        wolfRepository.delete(wolf);
    }

}
