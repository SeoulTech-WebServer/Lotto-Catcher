package seoultech.webserver.lotto.domain.record;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum LottoResult {

    FIRST("1등", 1, 6, 0),
    SECOND("2등", 2, 5, 1),
    THIRD("3등", 3, 5, 0),
    FOURTH("4등", 4, 4, 0),
    FIFTH("5등", 5, 3, 0),
    NOTHING("낙첨", 6, 0, 0);


    private final String value;
    private final int rank;
    private final int lottoNumberCount;
    private final int bonusNumberCount;

    public static LottoResult get(int lottoNumberCount, int bonusNumberCount) {
        if (lottoNumberCount == FIRST.getLottoNumberCount()) {
            return FIRST;
        }
        if (lottoNumberCount == SECOND.getLottoNumberCount() && bonusNumberCount == SECOND.getBonusNumberCount()) {
            return SECOND;
        }
        if (lottoNumberCount == THIRD.getLottoNumberCount() && bonusNumberCount == THIRD.getBonusNumberCount()) {
            return THIRD;
        }
        if (lottoNumberCount == FOURTH.getLottoNumberCount()) {
            return FOURTH;
        }
        if (lottoNumberCount == FIFTH.getLottoNumberCount()) {
            return FIFTH;
        }
        return NOTHING;
    }
}
