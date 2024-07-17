package pl.coderslab.fixairproject.service;


import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.coderslab.fixairproject.model.TechnicalSupport;
import pl.coderslab.fixairproject.repository.TechnicalSupportRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class TechnicalSupportService {

  private final TechnicalSupportRepository technicalSupportRepository;

  public List<TechnicalSupport> getAllTechnicalSupport() {
    return technicalSupportRepository.findAll();
  }

  public Optional<TechnicalSupport> getTechnicalSupportById(Long id) {
    return technicalSupportRepository.findById(id);
  }

  public TechnicalSupport saveTechnicalSupport(TechnicalSupport technicalSupport) {
    return technicalSupportRepository.save(technicalSupport);
  }

  public void deleteTechnicalSupport(Long id) {
    technicalSupportRepository.deleteById(id);
  }

}
