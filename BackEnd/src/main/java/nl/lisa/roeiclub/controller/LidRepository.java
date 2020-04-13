package nl.lisa.roeiclub.controller;

import nl.lisa.roeiclub.domein.Lid;
import nl.lisa.roeiclub.domein.Palen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component

public interface LidRepository extends CrudRepository<Lid, Long> {
}
