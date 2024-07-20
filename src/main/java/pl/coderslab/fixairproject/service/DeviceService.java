package pl.coderslab.fixairproject.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.coderslab.fixairproject.model.Client;
import pl.coderslab.fixairproject.model.Device;
import pl.coderslab.fixairproject.repository.DeviceRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeviceService {

  private final DeviceRepository deviceRepository;
  private final ClientService clientService;

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
    log.info("Deleted device in service");
    deviceRepository.deleteById(id);
  }

  public Optional<Device> getDeviceByClientId(Long clientId) {
    return deviceRepository.findDeviceByClientId(clientId);
  }

  public Device prepareDeviceForClient(Long clientId) {
    Optional<Device> deviceOptional = getDeviceByClientId(clientId);
    if (deviceOptional.isPresent()) {
      return deviceOptional.get();
    } else {
      Device device = new Device();
      Optional<Client> clientOptional = clientService.getClientById(clientId);
      clientOptional.ifPresent(device::setClient);
      return device;
    }
  }

  public Device saveOrUpdateDevice(Device device) {
    if (device.getId() != null) {
      Optional<Device> existingDeviceOptional = getDeviceById(device.getId());
      if (existingDeviceOptional.isPresent()) {
        Device existingDevice = existingDeviceOptional.get();
        device.setServiceRecords(existingDevice.getServiceRecords());
      }
    }
    return saveDevice(device);
  }

  public Device getDeviceForEdit(Long id) {
    Optional<Device> optionalDevice = getDeviceById(id);
    if (optionalDevice.isPresent()) {
      return optionalDevice.get();
    } else {
      log.info("Device with id {} not found", id);
      return null;
    }
  }


}
