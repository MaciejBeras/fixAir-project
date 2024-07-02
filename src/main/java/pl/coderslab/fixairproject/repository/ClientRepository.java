package pl.coderslab.fixairproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.fixairproject.model.Client;

@Repository
public interface ClientRepository extends JpaRepository <Client, Long> {

}
