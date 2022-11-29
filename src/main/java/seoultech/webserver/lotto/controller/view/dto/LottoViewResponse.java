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

    private String firstWinnerAmount;

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

                .firstWinnerAmount(toWinAmount(history.getFirstWinnerAmount()))
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

    private static String toWinAmount(Long amount) {
        String winAmount = amount.toString();
        String[] amountStr = winAmount.split("");
        StringBuilder tmp = new StringBuilder();
        int cnt = 0;
        for (int i = amountStr.length - 1; i >= 0; i--) {
            if (cnt == 3) {
                tmp.append(",");
                cnt = 0;
            }
            tmp.append(amountStr[i]);
            cnt++;
        }
        winAmount = tmp.reverse().toString();
        return winAmount;
    }
}
