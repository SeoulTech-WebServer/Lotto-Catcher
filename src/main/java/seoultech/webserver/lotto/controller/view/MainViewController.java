package seoultech.webserver.lotto.controller.view;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import seoultech.webserver.lotto.controller.view.dto.LottoViewResponse;
import seoultech.webserver.lotto.domain.history.History;
import seoultech.webserver.lotto.service.history.HistoryService;

@Controller
@AllArgsConstructor
public class MainViewController {

    private final HistoryService historyService;

    @GetMapping
    public String main(Model model, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userId")) {
                History history = historyService.findFirst();
                String userId = cookie.getValue();
                model.addAttribute("userId", userId);
                model.addAttribute("history", LottoViewResponse.of(history));
                return "main";
            }
        }
        return "redirect:/login";
    }
}
