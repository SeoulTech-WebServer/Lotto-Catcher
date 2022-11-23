package seoultech.webserver.lotto.service.user.response;

import lombok.*;
import seoultech.webserver.lotto.domain.history.History;
import seoultech.webserver.lotto.domain.record.LottoRecord;
import seoultech.webserver.lotto.domain.user.User;

import java.util.List;
import java.util.stream.Collectors;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class MypageInfoResponse {

    private String email;
    private List<RecordInfo> records;

    @ToString
    @Getter
    @Builder(access = AccessLevel.PRIVATE)
    private static class RecordInfo {

        private String round;
        private String lottoNumber;
        private String winAmount;
        private String result;
    }

    public static MypageInfoResponse of(User user, List<LottoRecord> lottoRecords) {
        return MypageInfoResponse.builder()
                .email(user.getEmail())
                .records(lottoRecords.stream()
                        .map(lottoRecord -> RecordInfo.builder()
                                .round(lottoRecord.getRound().toString())
                                .lottoNumber(toLottoNumber(List.of(
                                        lottoRecord.getNumberOne(),
                                        lottoRecord.getNumberTwo(),
                                        lottoRecord.getNumberThree(),
                                        lottoRecord.getNumberFour(),
                                        lottoRecord.getNumberFive(),
                                        lottoRecord.getNumberSix(),
                                        lottoRecord.getNumberBonus())))
                                .winAmount(toWinAmount(lottoRecord.getWinAmount()))
                                .result(lottoRecord.getLottoResult().getValue())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    private static String toLottoNumber(List<Integer> numbers) {
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
