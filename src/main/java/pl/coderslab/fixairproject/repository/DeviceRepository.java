package pl.coderslab.fixairproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.fixairproject.model.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

}
