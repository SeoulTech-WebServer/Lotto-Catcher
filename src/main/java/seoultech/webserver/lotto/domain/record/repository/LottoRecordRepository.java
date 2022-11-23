package seoultech.webserver.lotto.domain.record.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seoultech.webserver.lotto.domain.record.LottoRecord;

public interface LottoRecordRepository extends JpaRepository<LottoRecord, Long>, LottoRecordRepositoryCustom {
}
