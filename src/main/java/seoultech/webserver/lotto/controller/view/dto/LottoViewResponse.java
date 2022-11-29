package seoultech.webserver.lotto.controller.view.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import seoultech.webserver.lotto.domain.history.History;

@Builder
@Getter
@AllArgsConstructor
public class LottoViewResponse {

  private Long id;
  private Integer round;
  private String lottoryAt;
  private Integer firstWinnerCount;
  private Integer secondWinnerCount;
  private Integer thirdWinnerCount;
  private Integer fourthWinnerCount;
  private Integer fifthWinnerCount;

  private Long firstWinnerAmount;

  private Long secondWinnerAmount;

  private Long thirdWinnerAmount;

  private Long fourthWinnerAmount;

  private Long fifthWinnerAmount;

  private LottoNumberResponse numberOne;

  private LottoNumberResponse numberTwo;

  private LottoNumberResponse numberThree;

  private LottoNumberResponse numberFour;

  private LottoNumberResponse numberFive;

  private LottoNumberResponse numberSix;

  private LottoNumberResponse numberBonus;

  public static LottoViewResponse of(History history) {
    return LottoViewResponse.builder()
        .id(history.getId())
        .round(history.getRound())
        .lottoryAt(history.getLotteryAt().toString())

        .firstWinnerCount(history.getFifthWinnerCount())
        .secondWinnerCount(history.getSecondWinnerCount())
        .thirdWinnerCount(history.getThirdWinnerCount())
        .fourthWinnerCount(history.getFourthWinnerCount())
        .fifthWinnerCount(history.getFirstWinnerCount())

        .firstWinnerAmount(history.getFirstWinnerAmount())
        .secondWinnerAmount(history.getSecondWinnerAmount())
        .thirdWinnerAmount(history.getThirdWinnerAmount())
        .fourthWinnerAmount(history.getFourthWinnerAmount())
        .fifthWinnerAmount(history.getFifthWinnerAmount())
        .numberOne(new LottoNumberResponse(history.getNumberOne()))
        .numberTwo(new LottoNumberResponse(history.getNumberTwo()))
        .numberThree(new LottoNumberResponse(history.getNumberThree()))
        .numberFour(new LottoNumberResponse(history.getNumberFour()))
        .numberFive(new LottoNumberResponse(history.getNumberFive()))
        .numberSix(new LottoNumberResponse(history.getNumberSix()))
        .numberBonus(new LottoNumberResponse(history.getNumberBonus()))
        .build();
  }
}
