package nl.lisa.roeiclub.controller;

import nl.lisa.roeiclub.domein.Account;
import nl.lisa.roeiclub.domein.Palen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface AccountRepository extends CrudRepository<Account, Long> {
    List<Account> findByGebruikersnaam(String gebruikersnaam);
}
