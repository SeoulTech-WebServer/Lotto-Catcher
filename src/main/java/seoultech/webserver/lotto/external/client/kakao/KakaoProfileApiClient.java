package seoultech.webserver.lotto.external.client.kakao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import seoultech.webserver.lotto.external.client.kakao.dto.response.KakaoProfileResponse;

@FeignClient(name = "kakaoProfileApiClient", url = "https://kapi.kakao.com")
public interface KakaoProfileApiClient {

    @GetMapping("/v2/user/me")
    KakaoProfileResponse getProfileInfo(
            @RequestHeader("Authorization") String accessToken,
            @RequestParam String[] propertyKeys);
}
