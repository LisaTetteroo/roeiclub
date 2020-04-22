package nl.lisa.roeiclub.controller;

import nl.lisa.roeiclub.domein.Boot;
import nl.lisa.roeiclub.domein.Reservering;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface ReserveringRepository extends CrudRepository <Reservering, Long> {
    List<Reservering> findByBoot(Boot boot);

}
