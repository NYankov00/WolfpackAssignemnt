package guru.springframework.springmvcrest.bootstrap;

import guru.springframework.springmvcrest.domain.Gender;
import guru.springframework.springmvcrest.domain.Pack;
import guru.springframework.springmvcrest.domain.Wolf;
import guru.springframework.springmvcrest.repositories.PackRepository;
import guru.springframework.springmvcrest.repositories.WolfRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component
public class BootStrapData implements CommandLineRunner {

    private final WolfRepository wolfRepository;
    private final PackRepository packRepository;

    public BootStrapData(WolfRepository wolfRepository, PackRepository packRepository) {
        this.wolfRepository = wolfRepository;
        this.packRepository = packRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //Add some data
        System.out.println("Loading Wolves Data");

        Wolf w1 = new Wolf();
        w1.setName("Alaska");
        w1.setGender(Gender.FEMALE);
        w1.setBirthdate(LocalDate.of(2020, Month.JANUARY, 8));
        w1.setLocation("Eindhoven");
        wolfRepository.save(w1);

        Wolf w2 = new Wolf();
        w2.setName("Diego");
        w2.setGender(Gender.MALE);
        w2.setBirthdate(LocalDate.of(2018, Month.FEBRUARY, 20));
        w2.setLocation("Eindhoven");
        wolfRepository.save(w2);

        Wolf w3 = new Wolf();
        w3.setName("Storm");
        w3.setGender(Gender.FEMALE);
        w3.setBirthdate(LocalDate.of(2020, Month.JUNE, 18));
        w3.setLocation("Eindhoven");
        wolfRepository.save(w3);

        System.out.println("Loading Packs Data");

        Pack p1 = new Pack();
        p1.setName("AllStars");
        packRepository.save(p1);
    }
}
