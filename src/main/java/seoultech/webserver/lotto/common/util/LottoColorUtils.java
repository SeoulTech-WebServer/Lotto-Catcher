package seoultech.webserver.lotto.common.util;

public class LottoColorUtils {

  /*
   *  @params : number : 로또 번호 0~45
   *  @return : 색상 값
   *  ~10 -> 노란색
   *  ~20 -> 파란색
   *  ~30 -> 빨간색
   *  ~40 -> 회식
   *  ~나머지 -> 초록색
   */

  public static String findColor(int number) {
    if (number <= 10) {
      return "#FFBB00";
    }
    if (number <= 20) {
      return "#4374D9";
    }

    if (number <= 30) {
      return "#FF0000";
    }
    if (number <= 40) {
      return "#8C8C8C";
    }
    return "#47C83E";
  }

}
