package seoultech.webserver.lotto.service.crawling;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import seoultech.webserver.lotto.domain.history.History;
import seoultech.webserver.lotto.domain.history.repository.HistoryRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class CrawlingService {

    private final String crawlingUrl = "https://dhlottery.co.kr/gameResult.do?method=byWin";

    private final HistoryRepository historyRepository;

    /**
     * 토요일 22시 0분 0초마다 실행
     */
    @Scheduled(cron = "0  0  22  *  *  6")
    public void crawlingLottoResult() {
        try {
            Document document = Jsoup.connect(crawlingUrl).get();

            List<Element> winResultElements = document.getElementsByClass("win_result");
            List<String> roundTmp = new ArrayList<>(List.of(winResultElements.get(0).select("h4").text().replaceAll("[^0-9]", " ").split(" ")));
            List<String> lotteryAtWinNumberTmp = new ArrayList<>(List.of(winResultElements.get(0).select("p").text().replaceAll("[^0-9]", " ").split(" ")));
            roundTmp.removeAll(List.of(""));
            lotteryAtWinNumberTmp.removeAll(List.of(""));
            int round = Integer.parseInt(roundTmp.get(0));
            int year = Integer.parseInt(lotteryAtWinNumberTmp.get(0));
            int month = Integer.parseInt(lotteryAtWinNumberTmp.get(1));
            int dayOfMonth = Integer.parseInt(lotteryAtWinNumberTmp.get(2));
            LocalDate lotteryAt = LocalDate.of(year, month, dayOfMonth);
            int numberOne = Integer.parseInt(lotteryAtWinNumberTmp.get(3));
            int numberTwo = Integer.parseInt(lotteryAtWinNumberTmp.get(4));
            int numberThree = Integer.parseInt(lotteryAtWinNumberTmp.get(5));
            int numberFour = Integer.parseInt(lotteryAtWinNumberTmp.get(6));
            int numberFive = Integer.parseInt(lotteryAtWinNumberTmp.get(7));
            int numberSix = Integer.parseInt(lotteryAtWinNumberTmp.get(8));
            int numberBonus = Integer.parseInt(lotteryAtWinNumberTmp.get(9));

            List<Element> tableElements = document.getElementsByClass("tbl_data tbl_data_col");
            List<String> tableTmp = new ArrayList<>(List.of(tableElements.get(0).text().replaceAll("[^0-9,]", " ").split(" ")));
            tableTmp.removeAll(List.of("", " ", ","));
            int firstWinnerCount = Integer.parseInt(tableTmp.get(5).replaceAll("[^0-9]", ""));
            long firstWinnerAmount = Long.parseLong(tableTmp.get(6).replaceAll("[^0-9]", ""));
            int secondWinnerCount = Integer.parseInt(tableTmp.get(14).replaceAll("[^0-9]", ""));
            long secondWinnerAmount = Long.parseLong(tableTmp.get(15).replaceAll("[^0-9]", ""));
            int thirdWinnerCount = Integer.parseInt(tableTmp.get(19).replaceAll("[^0-9]", ""));
            long thirdWinnerAmount = Long.parseLong(tableTmp.get(20).replaceAll("[^0-9]", ""));
            int fourthWinnerCount = Integer.parseInt(tableTmp.get(24).replaceAll("[^0-9]", ""));
            long fourthWinnerAmount = 50000;
            int fifthWinnerCount = Integer.parseInt(tableTmp.get(29).replaceAll("[^0-9]", ""));
            long fifthWinnerAmount = 5000;

            historyRepository.save(History.newInstance(round, lotteryAt, firstWinnerCount, secondWinnerCount, thirdWinnerCount, fourthWinnerCount, fifthWinnerCount, firstWinnerAmount, secondWinnerAmount, thirdWinnerAmount, fourthWinnerAmount, fifthWinnerAmount, numberOne, numberTwo, numberThree, numberFour, numberFive, numberSix, numberBonus));
        } catch (Exception exception) {
            log.error("크롤링 실패");
        }
    }
}
