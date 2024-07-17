package pl.coderslab.fixairproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.fixairproject.model.TechnicalSupport;

public interface TechnicalSupportRepository extends JpaRepository <TechnicalSupport, Long> {

}
