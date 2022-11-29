package seoultech.webserver.lotto.service.record;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoultech.webserver.lotto.controller.record.dto.CreateRecordRequest;
import seoultech.webserver.lotto.domain.history.History;
import seoultech.webserver.lotto.domain.history.repository.HistoryRepository;
import seoultech.webserver.lotto.domain.record.LottoRecord;
import seoultech.webserver.lotto.domain.record.LottoResult;
import seoultech.webserver.lotto.domain.record.repository.LottoRecordRepository;
import seoultech.webserver.lotto.domain.user.User;
import seoultech.webserver.lotto.domain.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final LottoRecordRepository lottoRecordRepository;
    private final HistoryRepository historyRepository;
    private final UserRepository userRepository;

    @Transactional
    public LottoRecord createRound(CreateRecordRequest recordRequest, Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));

        History history = historyRepository.findByRound(recordRequest.getRound())
            .orElseThrow(() -> new RuntimeException("회차 정보를 찾을 수 없습니다."));

        LottoResult lottoResult = getLottoResult(recordRequest, history);
        Long recordAmount = history.getAmount(lottoResult);
        LottoRecord lottoRecord = generateRecord(user, lottoResult, recordAmount, recordRequest);
        return lottoRecordRepository.save(lottoRecord);
    }

    private LottoRecord generateRecord(User user, LottoResult lottoResult, Long amount,
        CreateRecordRequest recordRequest) {
        return LottoRecord.builder()
            .user(user)
            .round(recordRequest.getRound())
            .numberOne(recordRequest.getNumberOne())
            .numberTwo(recordRequest.getNumberTwo())
            .numberThree(recordRequest.getNumberThree())
            .numberFour(recordRequest.getNumberFour())
            .numberFive(recordRequest.getNumberFive())
            .numberSix(recordRequest.getNumberSix())
            .numberBonus(recordRequest.getNumberBonus())
            .lottoResult(lottoResult)
            .winAmount(amount)
            .build();
    }


    private LottoResult getLottoResult(CreateRecordRequest recordRequest, History history) {
        int matchCount = 0;
        int bonusCount = 0;
        if (recordRequest.getNumberOne().equals(history.getNumberOne())) {
            matchCount++;
        }
        if (recordRequest.getNumberTwo().equals(history.getNumberTwo())) {
            matchCount++;
        }
        if (recordRequest.getNumberThree().equals(history.getNumberThree())) {
            matchCount++;
        }
        if (recordRequest.getNumberFour().equals(history.getNumberFour())) {
            matchCount++;
        }
        if (recordRequest.getNumberFive().equals(history.getNumberFive())) {
            matchCount++;
        }
        if (recordRequest.getNumberSix().equals(history.getNumberSix())) {
            matchCount++;
        }
        if (recordRequest.getNumberBonus().equals(history.getNumberSix())) {
            bonusCount++;
        }
        return LottoResult.get(matchCount, bonusCount);
    }
}
