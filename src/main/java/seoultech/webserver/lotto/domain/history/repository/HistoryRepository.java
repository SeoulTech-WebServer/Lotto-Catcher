package seoultech.webserver.lotto.domain.history.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seoultech.webserver.lotto.domain.history.History;

public interface HistoryRepository extends JpaRepository<History, Long>, HistoryRepositoryCustom {
}
