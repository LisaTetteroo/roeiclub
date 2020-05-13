package nl.lisa.roeiclub.controller;

import nl.lisa.roeiclub.domein.Account;
import nl.lisa.roeiclub.domein.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component

public interface AdminRepository extends CrudRepository<Admin, Long> {
    Optional<Admin> findByGebruikersnaam(String gebruikersnaam);
}
