package seoultech.webserver.lotto.service.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoultech.webserver.lotto.common.util.HttpHeaderUtils;
import seoultech.webserver.lotto.domain.user.User;
import seoultech.webserver.lotto.domain.user.UserSocialType;
import seoultech.webserver.lotto.domain.user.repository.UserRepository;
import seoultech.webserver.lotto.external.client.kakao.KakaoProfileApiClient;
import seoultech.webserver.lotto.external.client.kakao.KakaoTokenApiClient;
import seoultech.webserver.lotto.external.client.kakao.dto.response.KakaoProfileResponse;
import seoultech.webserver.lotto.external.client.kakao.dto.response.KakaoTokenResponse;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {

    @Value("${oauth.kakao.clientId}")
    private String clientId;

    @Value("${oauth.kakao.redirectUri}")
    private String redirectUri;

    private final KakaoTokenApiClient kakaoTokenApiCaller;
    private final KakaoProfileApiClient kakaoProfileApiCaller;
    private final UserRepository userRepository;

    public KakaoProfileResponse getKakaoProfile(String code) {
        String[] propertyKeys = {"kakao_account.email"};
        KakaoTokenResponse tokenResponse = kakaoTokenApiCaller.getTokenInfo("authorization_code", clientId, redirectUri, code);
        return kakaoProfileApiCaller.getProfileInfo(HttpHeaderUtils.withBearerToken(tokenResponse.getAccessToken()), propertyKeys);
    }

    public User login(String socialId, UserSocialType socialType, String email) {
        User user = userRepository.findUserBySocialIdAndSocialType(socialId, socialType);
        if (user == null) {
            user = userRepository.save(User.newInstance(socialId, socialType, email));
        }
        return user;
    }
}
