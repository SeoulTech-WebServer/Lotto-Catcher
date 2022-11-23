package seoultech.webserver.lotto.domain.record.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import seoultech.webserver.lotto.domain.record.LottoRecord;
import seoultech.webserver.lotto.domain.user.User;

import java.util.List;

import static seoultech.webserver.lotto.domain.record.QLottoRecord.lottoRecord;

@RequiredArgsConstructor
public class LottoRecordRepositoryImpl implements LottoRecordRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<LottoRecord> findLottoRecordsByUser(User user) {
        return queryFactory
                .selectFrom(lottoRecord)
                .where(
                        lottoRecord.user.eq(user)
                )
                .orderBy(lottoRecord.round.desc())
                .fetch();
    }
}
