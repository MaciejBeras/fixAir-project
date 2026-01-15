package pl.coderslab.fixairproject.service;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import pl.coderslab.fixairproject.model.Client;
import pl.coderslab.fixairproject.repository.ClientRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientService {

  private final ClientRepository clientRepository;

  public List<Client> getAllClients() {
    return clientRepository.findAll();
  }

  public Optional<Client> getClientById(Long id) {
    return clientRepository.findById(id);
  }

  public Client saveClient(Client client) {
    return clientRepository.save(client);
  }

  public void deleteClient(Long id) {
    clientRepository.deleteById(id);
  }

  public String processClientForm(@Valid Client client, BindingResult result) {
    if (result.hasErrors()) {
      return "clientForm";
    }
    if (client.getId() != null) {
      Optional<Client> existingClient = getClientById(client.getId());
      existingClient.ifPresent(value -> client.setDevice(value.getDevice()));
    }
    saveClient(client);
    log.info("Saved {}", client);
    return "redirect:/client/form/all";
  }

}
