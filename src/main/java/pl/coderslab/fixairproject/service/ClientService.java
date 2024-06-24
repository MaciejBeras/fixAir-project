package pl.coderslab.fixairproject.service;

import java.util.List;
import java.util.Optional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.coderslab.fixairproject.model.Client;
import pl.coderslab.fixairproject.repository.ClientRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientService {

  private ClientRepository clientRepository;

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

}
