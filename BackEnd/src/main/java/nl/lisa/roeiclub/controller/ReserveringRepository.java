package nl.lisa.roeiclub.controller;

import nl.lisa.roeiclub.domein.Reservering;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component

public interface ReserveringRepository extends CrudRepository <Reservering, Long> {
}
