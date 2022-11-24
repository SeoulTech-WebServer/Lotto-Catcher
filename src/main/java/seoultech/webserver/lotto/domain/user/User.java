package seoultech.webserver.lotto.domain.user;

import lombok.*;
import seoultech.webserver.lotto.domain.common.AuditingTimeEntity;
import seoultech.webserver.lotto.domain.record.LottoRecord;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Column(nullable = false, length = 100)
    private String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<LottoRecord> lottoRecords = new ArrayList<>();

    public static User newInstance(String socialId, UserSocialType socialType, String email) {
        return User.builder()
                .socialInfo(SocialInfo.of(socialId, socialType))
                .email(email)
                .build();
    }
}
