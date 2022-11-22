package seoultech.webserver.lotto.controller.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import seoultech.webserver.lotto.domain.user.User;
import seoultech.webserver.lotto.domain.user.UserSocialType;
import seoultech.webserver.lotto.domain.user.repository.UserRepository;
import seoultech.webserver.lotto.external.client.kakao.dto.response.KakaoProfileResponse;
import seoultech.webserver.lotto.service.auth.AuthService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private static final UserSocialType socialType = UserSocialType.KAKAO;
    private final AuthService authService;
    private final UserRepository userRepository;

    @GetMapping("/oauth/kakao")
    public String login(@RequestParam(value = "code", required = false) String code, HttpServletResponse response) {
        KakaoProfileResponse kakaoProfile = authService.getKakaoProfile(code);
        String socialId = kakaoProfile.getId();
        String email = kakaoProfile.getKakaoAccount().getEmail();
        User user = authService.login(socialId, socialType, email);
        Cookie cookie = new Cookie("userId", user.getId().toString());
        cookie.setDomain("localhost");
        cookie.setPath("/");
        cookie.setSecure(true);
        response.addCookie(cookie);
        return "redirect:/";
    }
}
