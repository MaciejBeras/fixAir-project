package pl.coderslab.fixairproject.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.fixairproject.model.Device;
import pl.coderslab.fixairproject.model.ServiceRecord;

@Repository
public interface ServiceRecordRepository extends JpaRepository <ServiceRecord, Long> {

  @Query("SELECT s FROM ServiceRecord s WHERE s.device.id = :deviceId")
  Optional<ServiceRecord> findServiceRecordByDeviceId(@Param("deviceId") Long deviceId);
}
