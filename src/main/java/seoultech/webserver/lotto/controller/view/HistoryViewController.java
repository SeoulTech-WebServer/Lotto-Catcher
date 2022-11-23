package seoultech.webserver.lotto.controller.view;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import seoultech.webserver.lotto.service.history.HistoryService;
import seoultech.webserver.lotto.service.history.dto.response.HistoryResponse;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HistoryViewController {

    private final HistoryService historyService;

    @GetMapping("/history")
    public String history(Model model, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userId")) {
                String userId = cookie.getValue();
                List<HistoryResponse> histories = historyService.findAllHistories();
                model.addAttribute("userId", userId);
                model.addAttribute("histories", histories);
                return "lotto-history";
            }
        }
        return "redirect:/login";
    }
}
