package pl.coderslab.fixairproject.repository;

import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.fixairproject.model.Device;

@Repository
@Transactional
public interface DeviceRepository extends JpaRepository<Device, Long> {

  @Query("SELECT d FROM Device d WHERE d.client.id = :clientId")
  Optional<Device> findDeviceByClientId(@Param("clientId") Long clientId);

}
