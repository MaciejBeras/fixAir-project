package pl.coderslab.fixairproject.test;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @GetMapping
  public String toUpperCase (@RequestParam String name) {
    return name.toUpperCase();
  }

}


//1. Zrób endpoint w controllerze, który przyjmie parametr name,
//zmieni go na wielkie litery i zwóci użytkownikowi.