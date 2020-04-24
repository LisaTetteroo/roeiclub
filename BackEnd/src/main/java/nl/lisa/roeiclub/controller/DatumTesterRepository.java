package nl.lisa.roeiclub.controller;

import nl.lisa.roeiclub.domein.Boot;
import nl.lisa.roeiclub.domein.DatumTester;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component

public interface DatumTesterRepository extends CrudRepository<DatumTester, Long> {

}
