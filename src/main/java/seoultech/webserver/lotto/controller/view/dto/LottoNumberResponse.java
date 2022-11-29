package seoultech.webserver.lotto.controller.view.dto;

import lombok.Getter;
import seoultech.webserver.lotto.common.util.LottoColorUtils;

@Getter
public class LottoNumberResponse {

  private Integer number;
  private String color;

  public LottoNumberResponse(Integer number) {
    this.number = number;
    this.color = LottoColorUtils.findColor(number);
  }
}
