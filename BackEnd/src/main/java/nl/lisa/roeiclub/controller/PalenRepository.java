package nl.lisa.roeiclub.controller;

import nl.lisa.roeiclub.domein.Palen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component

public interface PalenRepository extends CrudRepository<Palen, Long> {
}
