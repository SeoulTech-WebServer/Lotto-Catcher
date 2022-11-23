package seoultech.webserver.lotto.domain.history.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import seoultech.webserver.lotto.domain.history.History;

import java.util.List;

import static seoultech.webserver.lotto.domain.history.QHistory.history;

@RequiredArgsConstructor
public class HistoryRepositoryImpl implements HistoryRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<History> findAllHistoryOrderByRound() {
        return queryFactory
                .selectFrom(history)
                .orderBy(history.round.desc())
                .fetch();
    }
}
