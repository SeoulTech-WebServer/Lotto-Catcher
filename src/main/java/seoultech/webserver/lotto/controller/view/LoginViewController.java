package seoultech.webserver.lotto.controller.view;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginViewController {

    @Value("${oauth.kakao.clientId}")
    private String clientId;

    @Value("${oauth.kakao.redirectUri}")
    private String redirectUri;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("clientId", clientId);
        model.addAttribute("redirectUri", redirectUri);
        model.addAttribute("code", "code");
        return "login";
    }
}
