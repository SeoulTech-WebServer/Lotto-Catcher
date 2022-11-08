package seoultech.webserver.lotto.domain.user;

import lombok.*;
import seoultech.webserver.lotto.domain.common.AuditingTimeEntity;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class User extends AuditingTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private SocialInfo socialInfo;

    public static User newInstance(String socialId, UserSocialType socialType) {
        return User.builder()
                .socialInfo(SocialInfo.of(socialId, socialType))
                .build();
    }
}
