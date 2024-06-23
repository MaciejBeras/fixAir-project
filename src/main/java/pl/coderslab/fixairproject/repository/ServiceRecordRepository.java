package pl.coderslab.fixairproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.fixairproject.model.ServiceRecord;

public interface ServiceRecordRepository extends JpaRepository <ServiceRecord, Long> {

}
