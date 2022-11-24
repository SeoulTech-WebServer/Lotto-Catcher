package seoultech.webserver.lotto.domain.record.repository;

import seoultech.webserver.lotto.domain.record.LottoRecord;
import seoultech.webserver.lotto.domain.user.User;

import java.util.List;

public interface LottoRecordRepositoryCustom {

    public List<LottoRecord> findLottoRecordsByUser(User user);
}
