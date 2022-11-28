package seoultech.webserver.lotto.controller.view;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import seoultech.webserver.lotto.controller.view.dto.LottoViewResponse;
import seoultech.webserver.lotto.domain.history.History;
import seoultech.webserver.lotto.service.history.HistoryService;

@Controller
@AllArgsConstructor
public class LottoViewController {

    private final HistoryService historyService;

    @GetMapping("/test")
    public String test(Model model) {

        History history = historyService.findFirst();
        model.addAttribute("history", LottoViewResponse.of(history));
        return "main";
    }
}
