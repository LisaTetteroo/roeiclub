package nl.lisa.roeiclub.controller;

import nl.lisa.roeiclub.domein.Boot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface BootRepository extends CrudRepository<Boot, Long> {
    List<Boot> findByBeschikbaarTrue();
}
