package seoultech.webserver.lotto.external.client.kakao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import seoultech.webserver.lotto.external.client.kakao.dto.response.KakaoTokenResponse;

@FeignClient(name = "kakaoTokenApiClient", url = "https://kauth.kakao.com")
public interface KakaoTokenApiClient {

    @PostMapping("/oauth/token")
    KakaoTokenResponse getTokenInfo(
            @RequestParam(name = "grant_type") String grantType,
            @RequestParam(name = "client_id") String clientId,
            @RequestParam(name = "redirect_uri") String redirectUri,
            @RequestParam(name = "code") String code);
}
