package seoultech.webserver.lotto.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("example")
    public String example(Model model) {
        return "example";
    }
}
