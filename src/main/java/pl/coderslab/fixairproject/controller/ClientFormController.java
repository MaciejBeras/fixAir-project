package pl.coderslab.fixairproject.controller;


import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
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
import pl.coderslab.fixairproject.model.Client;
import pl.coderslab.fixairproject.model.Gender;
import pl.coderslab.fixairproject.service.ClientService;

@Slf4j
@Controller
@RequestMapping("/client/form")
@RequiredArgsConstructor
public class ClientFormController {

  private final ClientService clientService;


  @GetMapping("/all")
  public String showAllClients() {
    return "clientList";
  }

  @GetMapping
  public String showClientForm(Model model) {
    model.addAttribute("client", new Client());
    log.info("Client form has been opened");
    return "clientForm";
  }

  @PostMapping
  public String processClientForm(@Valid @ModelAttribute Client client, BindingResult result) {
    if (result.hasErrors()) {
      return "clientForm";
    }
    clientService.saveClient(client);
    log.info("Saved {}", client);
    return "redirect:/client/form";
  }

  @PostMapping("/edit/{id}")
  public String editClient(@PathVariable Long id, Model model) {
    Optional<Client> client = clientService.getClientById(id);
    model.addAttribute("client", client);
    log.info("Edited client with id {}", id);
    return "clientForm";
  }


  @PostMapping("/delete/{id}")
  public String deleteClient(@PathVariable Long id) {
    clientService.deleteClient(id);
    log.info("Deleted client with id {}", id);
    return "redirect:/client/form/all";
  }


  @ModelAttribute("clients")
  public List<Client> getClient() {
    return clientService.getAllClients();
  }

  @ModelAttribute("genders")
  public Gender[] getGenders() {
    return Gender.values();
  }

}
