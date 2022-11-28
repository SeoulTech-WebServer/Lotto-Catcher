package seoultech.webserver.lotto.controller.view.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import seoultech.webserver.lotto.domain.record.LottoRecord;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LottoMatchResultResponse {

    private Integer round;
    private String matchResult;
    private Long winAmount;


    public static LottoMatchResultResponse of(LottoRecord lottoRecord){
        return LottoMatchResultResponse.builder()
            .round(lottoRecord.getRound())
            .winAmount(lottoRecord.getWinAmount())
            .matchResult(lottoRecord.getLottoResult().getValue())
            .build();
    }
}
