package pl.coderslab.fixairproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.fixairproject.model.ServiceRecord;

@Repository
public interface ServiceRecordRepository extends JpaRepository <ServiceRecord, Long> {

}
