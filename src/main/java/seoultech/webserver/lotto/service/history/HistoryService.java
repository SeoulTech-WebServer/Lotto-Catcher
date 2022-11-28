package seoultech.webserver.lotto.service.history;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoultech.webserver.lotto.domain.history.History;
import seoultech.webserver.lotto.domain.history.repository.HistoryRepository;
import seoultech.webserver.lotto.service.history.dto.response.HistoryResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class HistoryService {

    private final HistoryRepository historyRepository;

    public List<HistoryResponse> findAllHistories() {
        return historyRepository.findAllHistoryOrderByRound().stream()
                .map(HistoryResponse::of)
                .collect(Collectors.toList());
    }

    public History findFirst(){
        return historyRepository.findFirstByOrderByIdDesc()
            .orElseThrow(IllegalStateException::new);
    }
}
