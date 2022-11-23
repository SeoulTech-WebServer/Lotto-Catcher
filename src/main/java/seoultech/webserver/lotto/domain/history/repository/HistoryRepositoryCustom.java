package seoultech.webserver.lotto.domain.history.repository;

import seoultech.webserver.lotto.domain.history.History;

import java.util.List;

public interface HistoryRepositoryCustom {

    List<History> findAllHistoryOrderByRound();
}
