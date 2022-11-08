package seoultech.webserver.lotto.domain.history;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import seoultech.webserver.lotto.domain.common.AuditingTimeEntity;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class History extends AuditingTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer round;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDate lotteryAt;

    @Column(nullable = false)
    private Integer firstWinnerCount;

    @Column(nullable = false)
    private Integer secondWinnerCount;

    @Column(nullable = false)
    private Integer thirdWinnerCount;

    @Column(nullable = false)
    private Integer fourthWinnerCount;

    @Column(nullable = false)
    private Integer fifthWinnerCount;

    @Column(nullable = false)
    private Long firstWinnerAmount;

    @Column(nullable = false)
    private Long secondWinnerAmount;

    @Column(nullable = false)
    private Long thirdWinnerAmount;

    @Column(nullable = false)
    private Long fourthWinnerAmount;

    @Column(nullable = false)
    private Long fifthWinnerAmount;

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
}
