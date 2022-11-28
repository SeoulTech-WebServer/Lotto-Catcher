package seoultech.webserver.lotto.controller.view;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import seoultech.webserver.lotto.controller.record.dto.CreateRecordRequest;

@Controller
@AllArgsConstructor
public class LottoViewController {


    @GetMapping("/lotto")
    public String test(Model model) {

        model.addAttribute("recordRequest", new CreateRecordRequest());
        return "lotto";
    }
}
