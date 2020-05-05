package nl.lisa.roeiclub.controller;

import nl.lisa.roeiclub.domein.Foto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface FotoRepository extends CrudRepository<Foto, Long> {
}
