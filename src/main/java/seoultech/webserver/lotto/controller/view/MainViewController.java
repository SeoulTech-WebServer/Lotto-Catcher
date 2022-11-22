package seoultech.webserver.lotto.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MainViewController {

    @GetMapping
    public String main(Model model, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userId")) {
                String userId = cookie.getValue();
                model.addAttribute("userId", userId);
                return "main";
            }
        }
        return "redirect:/login";
    }
}
