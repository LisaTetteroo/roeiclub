package nl.lisa.roeiclub.controller;

import nl.lisa.roeiclub.domein.Account;
import nl.lisa.roeiclub.domein.Boot;
import nl.lisa.roeiclub.domein.Reservering;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component

public interface ReserveringRepository extends CrudRepository <Reservering, Long> {
    List<Reservering> findByBootAndDatum(Boot boot, LocalDate datum);
    Optional<Reservering> findByDatum(LocalDate datum);
    Iterable<Reservering> findByAccount(Account account);

}
