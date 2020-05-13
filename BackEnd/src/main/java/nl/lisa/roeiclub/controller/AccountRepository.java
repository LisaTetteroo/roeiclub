package nl.lisa.roeiclub.controller;

import nl.lisa.roeiclub.domein.Account;
import nl.lisa.roeiclub.domein.Lid;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component

public interface AccountRepository extends CrudRepository<Account, Long> {
    Optional<Account> findByGebruikersnaam(String gebruikersnaam);
    Optional<Account> findByLid(Lid lid);
}
