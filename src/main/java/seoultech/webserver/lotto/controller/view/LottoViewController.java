package seoultech.webserver.lotto.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LottoViewController {

  @GetMapping("/test")
  public String test() {

    return "main";
  }
}
