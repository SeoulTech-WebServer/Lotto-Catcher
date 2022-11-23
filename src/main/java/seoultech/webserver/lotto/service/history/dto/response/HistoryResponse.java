package seoultech.webserver.lotto.service.history.dto.response;

import lombok.*;
import seoultech.webserver.lotto.domain.history.History;

import java.util.List;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class HistoryResponse {

    private String round;
    private String winNumber;
    private String winCount;
    private String winAmount;

    public static HistoryResponse of(History history) {
        return HistoryResponse.builder()
                .round(history.getRound().toString())
                .winNumber(toWinNumber(List.of(
                        history.getNumberOne(),
                        history.getNumberTwo(),
                        history.getNumberThree(),
                        history.getNumberFour(),
                        history.getNumberFive(),
                        history.getNumberSix(),
                        history.getNumberBonus())))
                .winCount(history.getFirstWinnerCount().toString())
                .winAmount(toWinAmount(history.getFirstWinnerAmount()))
                .build();
    }

    private static String toWinNumber(List<Integer> numbers) {
        StringBuilder winNumber = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            winNumber.append(numbers.get(i).toString());
            if (i < 5) {
                winNumber.append(", ");
            }
            if (i == 5) {
                winNumber.append(" + ");
            }
        }
        return winNumber.toString();
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
