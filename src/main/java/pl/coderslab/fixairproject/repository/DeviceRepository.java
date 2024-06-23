package pl.coderslab.fixairproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.fixairproject.model.Device;

public interface DeviceRepository extends JpaRepository <Device, Long> {

}
