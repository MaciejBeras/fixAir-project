package pl.coderslab.fixairproject.controller;


import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.fixairproject.model.Device;
import pl.coderslab.fixairproject.model.ServiceRecord;
import pl.coderslab.fixairproject.service.DeviceService;
import pl.coderslab.fixairproject.service.ServiceRecordService;

@Slf4j
@Controller
@RequestMapping("/serviceRecord/form")
@RequiredArgsConstructor
public class ServiceRecordFormController {

  private final ServiceRecordService serviceRecordService;

  @GetMapping("/all")
  public String showAllServiceRecords() {
    return "allServiceList";
  }

  @GetMapping()
  public String showServiceRecordForm(@RequestParam("deviceId") Long deviceId, Model model) {
    ServiceRecord serviceRecord = serviceRecordService.createServiceRecordForDevice(deviceId);
    model.addAttribute("serviceRecord", serviceRecord);
    return "serviceForm";
  }

  @PostMapping()
  public String processServiceRecordForm(@ModelAttribute ServiceRecord serviceRecord) {
    serviceRecordService.saveServiceRecord(serviceRecord);
    return "redirect:/client/form/all";
  }

  @ModelAttribute("serviceRecords")
  public List<ServiceRecord> getServiceRecords() {
    return serviceRecordService.getAllServiceRecord();
  }

}
