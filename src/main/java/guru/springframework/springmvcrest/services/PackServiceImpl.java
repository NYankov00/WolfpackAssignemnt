package guru.springframework.springmvcrest.services;

import guru.springframework.springmvcrest.domain.Pack;
import guru.springframework.springmvcrest.domain.Wolf;
import guru.springframework.springmvcrest.repositories.PackRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PackServiceImpl implements PackService {
    private final PackRepository packRepository;

    public PackServiceImpl(PackRepository packRepository) {
        this.packRepository = packRepository;
    }

    @Override
    public Pack findPackById(Long id) {
        return packRepository.findById(id).get();
    }

    @Override
    public List<Pack> findAllPacks() {
        return packRepository.findAll();
    }

    @Override
    public Pack savePack(Pack pack) {
        return packRepository.save(pack);
    }

    @Override
    public void deletePack(Pack pack) {
        Pack old = this.findPackById(pack.getId());
        packRepository.delete(pack);
    }

    @Override
    public List<Wolf> findAllWolves(Pack pack) {
        return packRepository.findAllWolvesForAPack(pack);
    }

    @Override
    public Pack addWolfToPack(Pack pack, Wolf wolf) {
        List<Wolf> wolves = findAllWolves(pack);
        wolves.add(wolf);
        pack.setWolves(wolves);
        return packRepository.save(pack);
    }

    @Override
    public Pack removeWolfFromPack(Pack pack, Wolf wolf) {
        List<Wolf> wolves = findAllWolves(pack);
        wolves.remove(wolf);
        pack.setWolves(wolves);
        return packRepository.save(pack);
    }


}
