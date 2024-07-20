package pl.coderslab.fixairproject.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.fixairproject.model.Device;
import pl.coderslab.fixairproject.service.ClientService;
import pl.coderslab.fixairproject.service.DeviceService;

@Slf4j
@Controller
@RequestMapping("/device/form")
@RequiredArgsConstructor
public class DeviceFormController {

  private final DeviceService deviceService;
  private final ClientService clientService;

  @GetMapping("/all")
  public String showAllDevices() {
    return "deviceList";
  }

@GetMapping()
public String showDeviceForm(@RequestParam("clientId") Long clientId, Model model) {
  Device device = deviceService.prepareDeviceForClient(clientId);
  model.addAttribute("device", device);
  if (device.getId() == null) {
    return "deviceForm";
  } else {
    return "clientDevice";
  }
}

  @PostMapping()
  public String processDeviceForm(@ModelAttribute Device device, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "deviceForm";
    }
    deviceService.saveOrUpdateDevice(device);
    return "redirect:/client/form/all";
  }

  @PostMapping("/edit/{id}")
  public String editDevice(@PathVariable Long id, Model model) {
    Device device = deviceService.getDeviceForEdit(id);
    if (device != null) {
      model.addAttribute("device", device);
      log.info("Edited device with id {}", id);
      return "deviceForm";
    } else {
      return "redirect:/device/form/all";
    }
  }

  @PostMapping("/delete/{id}")
  public String deleteDevice(@PathVariable Long id) {
    deviceService.deleteDevice(id);
    log.info("Deleted device with id {}", id);
    return "redirect:/client/form/all";
  }


  @ModelAttribute("devices")
  public List<Device> getDevices() {
    return deviceService.getAllDevice();
  }

}