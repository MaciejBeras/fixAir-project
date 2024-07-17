package pl.coderslab.fixairproject.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.fixairproject.model.TechnicalSupport;
import pl.coderslab.fixairproject.service.TechnicalSupportService;

@Slf4j
@Controller
@RequestMapping("/technicalSupport")
@RequiredArgsConstructor
public class TechnicalSupportController {

  private final TechnicalSupportService technicalSupportService;

  @GetMapping("/all")
  public String showAllClients() {
    return "technicalSupportList";
  }

  @ModelAttribute("technicalSupports")
  public List<TechnicalSupport> getTechnicalSupport() {
    return technicalSupportService.getAllTechnicalSupport();
  }
}
