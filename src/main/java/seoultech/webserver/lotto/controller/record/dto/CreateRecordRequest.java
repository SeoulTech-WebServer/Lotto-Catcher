package seoultech.webserver.lotto.controller.record.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CreateRecordRequest {

    @NotNull(message = "회차를 입력해주세요")
    @Positive(message = "정확히 입력해주세요")
    private Integer round;

    @NotNull(message = "번호를 입력해주세요")
    @Min(value = 1, message = "번호는 1~45만 입력가능합니다.")
    @Max(value = 45, message = "번호는 1~45만 입력가능합니다.")
    private Integer numberOne;

    @NotNull(message = "번호를 입력해주세요")
    @Min(value = 1, message = "번호는 1~45만 입력가능합니다.")
    @Max(value = 45, message = "번호는 1~45만 입력가능합니다.")
    private Integer numberTwo;

    @NotNull(message = "번호를 입력해주세요")
    @Min(value = 1, message = "번호는 1~45만 입력가능합니다.")
    @Max(value = 45, message = "번호는 1~45만 입력가능합니다.")
    private Integer numberThree;

    @NotNull(message = "번호를 입력해주세요")
    @Min(value = 1, message = "번호는 1~45만 입력가능합니다.")
    @Max(value = 45, message = "번호는 1~45만 입력가능합니다.")
    private Integer numberFour;

    @NotNull(message = "번호를 입력해주세요")
    @Min(value = 1, message = "번호는 1~45만 입력가능합니다.")
    @Max(value = 45, message = "번호는 1~45만 입력가능합니다.")
    private Integer numberFive;

    @NotNull(message = "번호를 입력해주세요")
    @Min(value = 1, message = "번호는 1~45만 입력가능합니다.")
    @Max(value = 45, message = "번호는 1~45만 입력가능합니다.")
    private Integer numberSix;

    @NotNull(message = "번호를 입력해주세요")
    @Min(value = 1, message = "번호는 1~45만 입력가능합니다.")
    @Max(value = 45, message = "번호는 1~45만 입력가능합니다.")
    private Integer numberBonus;
}
