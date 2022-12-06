package seoultech.webserver.lotto.controller.view;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import seoultech.webserver.lotto.service.user.UserService;
import seoultech.webserver.lotto.service.user.response.MypageInfoResponse;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Controller
public class MypageViewController {

    private final UserService userService;

    @GetMapping("/mypage")
    public String mypage(Model model, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies.length == 0) {
            return "redirect:/login";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userId")) {
                String userId = cookie.getValue();
                MypageInfoResponse mypageInfo = userService.getMypageInfo(Long.valueOf(userId));
                model.addAttribute("userId", userId);
                model.addAttribute("mypageInfo", mypageInfo);
                return "mypage";
            }
        }
        return "redirect:/login";
    }
}
