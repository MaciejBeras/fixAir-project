package pl.coderslab.fixairproject.controller;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.fixairproject.model.Client;
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


  @GetMapping()
  public String showDeviceForm(@RequestParam("clientId") Long clientId, Model model) {
    Device device = new Device();
    Optional<Client> clientOptional = clientService.getClientById(clientId);
    if (clientOptional.isPresent()) {
      device.setClient(clientOptional.get());
    }
    model.addAttribute("device", device);
    return "deviceForm";
  }

  @PostMapping()
  public String processDeviceForm(@ModelAttribute Device device) {
    deviceService.saveDevice(device);
    return "redirect:/client/form/all";
  }
}