package seoultech.webserver.lotto.controller.record;

import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import seoultech.webserver.lotto.controller.record.dto.CreateRecordRequest;
import seoultech.webserver.lotto.controller.view.dto.LottoMatchResultResponse;
import seoultech.webserver.lotto.domain.record.LottoRecord;
import seoultech.webserver.lotto.service.history.HistoryService;
import seoultech.webserver.lotto.service.record.RecordService;

@Slf4j
@Controller
@AllArgsConstructor
public class RecordController {

    private final HistoryService historyService;
    private final RecordService recordService;

    @PostMapping("/record")
    public String createRecord(Model model,
        @ModelAttribute("recordRequest") @Validated CreateRecordRequest recordRequest,
        BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError error : fieldErrors) {
                log.error(error.getDefaultMessage());
            }
            return "lotto";
        }

        Long userId = getUserId(request);

        if (userId == null) {
            return "redirect:/login";
        }

        LottoRecord record = recordService.createRound(recordRequest, userId);
        model.addAttribute("result", LottoMatchResultResponse.of(record));
        return "lotto-result";
    }

    private Long getUserId(HttpServletRequest request) {
        Long userId = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userId")) {
                String id = cookie.getValue();
                userId = Long.valueOf(id);
            }
        }
        return userId;
    }
}
