package pl.coderslab.fixairproject.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.coderslab.fixairproject.model.Client;
import pl.coderslab.fixairproject.model.Device;
import pl.coderslab.fixairproject.model.ServiceRecord;
import pl.coderslab.fixairproject.repository.ClientRepository;
import pl.coderslab.fixairproject.repository.ServiceRecordRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServiceRecordService {

  private final ServiceRecordRepository serviceRecordRepository;

  public List<ServiceRecord> getAllServiceRecord() {
    return serviceRecordRepository.findAll();
  }

  public Optional<ServiceRecord> getServiceRecordById(Long id) {
    return serviceRecordRepository.findById(id);
  }

  public ServiceRecord saveServiceRecord(ServiceRecord serviceRecord) {
    return serviceRecordRepository.save(serviceRecord);
  }

  public void deleteServiceRecord(Long id) {
    serviceRecordRepository.deleteById(id);
  }

  public List<ServiceRecord> getServiceRecordByDeviceId(Long deviceId) {
    return serviceRecordRepository.findServiceRecordByDeviceId(deviceId).orElse(List.of());
  }


}
