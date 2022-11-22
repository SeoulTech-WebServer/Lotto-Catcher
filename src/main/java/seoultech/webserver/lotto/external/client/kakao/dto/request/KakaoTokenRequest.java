package seoultech.webserver.lotto.external.client.kakao.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder(access = AccessLevel.PRIVATE)
public class KakaoTokenRequest {

    private String grantType;
    private String clientId;
    private String redirectUri;
    private String code;

    public static KakaoTokenRequest of(String grantType, String clientId, String redirectUri, String code) {
        return KakaoTokenRequest.builder()
                .grantType(grantType)
                .clientId(clientId)
                .redirectUri(redirectUri)
                .code(code)
                .build();
    }
}
