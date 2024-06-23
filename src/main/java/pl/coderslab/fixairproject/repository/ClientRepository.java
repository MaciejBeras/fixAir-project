package pl.coderslab.fixairproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.fixairproject.model.Client;

public interface ClientRepository extends JpaRepository <Client, Long> {

}
