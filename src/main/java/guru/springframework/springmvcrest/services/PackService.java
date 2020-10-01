package guru.springframework.springmvcrest.services;

import guru.springframework.springmvcrest.domain.Pack;
import guru.springframework.springmvcrest.domain.Wolf;

import java.util.List;

public interface PackService {
    Pack findPackById(Long id);

    List<Pack> findAllPacks();

    Pack savePack(Pack pack);

    void deletePack(Pack pack);

    List<Wolf> findAllWolves(Pack pack);

    Pack addWolfToPack(Pack pack, Wolf wolf);

    Pack removeWolfFromPack(Pack pack, Wolf wolf);
}
