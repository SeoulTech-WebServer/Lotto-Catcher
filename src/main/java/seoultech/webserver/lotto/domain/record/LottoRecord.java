package seoultech.webserver.lotto.domain.record;

import lombok.*;
import seoultech.webserver.lotto.domain.common.AuditingTimeEntity;
import seoultech.webserver.lotto.domain.user.User;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PUBLIC)
public class LottoRecord extends AuditingTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private Integer round;

    @Column(nullable = false)
    private Integer numberOne;

    @Column(nullable = false)
    private Integer numberTwo;

    @Column(nullable = false)
    private Integer numberThree;

    @Column(nullable = false)
    private Integer numberFour;

    @Column(nullable = false)
    private Integer numberFive;

    @Column(nullable = false)
    private Integer numberSix;

    @Column(nullable = false)
    private Integer numberBonus;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LottoResult lottoResult;

    @Column(nullable = false)
    private Long winAmount;
}
