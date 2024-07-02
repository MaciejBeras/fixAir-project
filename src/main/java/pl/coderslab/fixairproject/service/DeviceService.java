package pl.coderslab.fixairproject.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.coderslab.fixairproject.model.Device;
import pl.coderslab.fixairproject.repository.DeviceRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeviceService {

  private final DeviceRepository deviceRepository;

  public List<Device> getAllDevice() {
    return deviceRepository.findAll();
  }

  public Optional<Device> getDeviceById(Long id) {
    return deviceRepository.findById(id);
  }

  public Device saveDevice(Device device) {
    return deviceRepository.save(device);
  }

  public void deleteDevice(Long id) {
    deviceRepository.deleteById(id);
  }

}
