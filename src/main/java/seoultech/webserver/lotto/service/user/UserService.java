package seoultech.webserver.lotto.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoultech.webserver.lotto.domain.record.LottoRecord;
import seoultech.webserver.lotto.domain.record.repository.LottoRecordRepository;
import seoultech.webserver.lotto.domain.user.User;
import seoultech.webserver.lotto.domain.user.repository.UserRepository;
import seoultech.webserver.lotto.service.user.response.MypageInfoResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final LottoRecordRepository lottoRecordRepository;

    public MypageInfoResponse getMypageInfo(Long userId) {
        User user = userRepository.findUserById(userId);
        List<LottoRecord> lottoRecords = lottoRecordRepository.findLottoRecordsByUser(user);
        return MypageInfoResponse.of(user, lottoRecords);
    }
}
