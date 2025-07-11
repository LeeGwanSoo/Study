package kr.co.joneconsulting.myrestfulservice.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(value = {"password","ssn"})
@AllArgsConstructor
@Schema(description = "사용자 상세정보를 위한 도메인 객체")
public class User {

    @Schema(title = "사용자 ID", description = "사용자 ID는 자동생성됩니다.")
    private Integer id;

    @Schema(title = "사용자 이름", description = "사용자 이름을 입력합니다.")
    @Size(min = 2, message = "Name은 2글자 이상 입력해주세요.")
    private String name;

    @Past(message = "등록일은 미래 날짜를 입력하실 수 없습니다.")
    private Date joinDate;

    @Schema(title = "사용자 비밀번호", description = "사용자 비밀번호 입력합니다.")
//    @JsonIgnore
    private String password;

//    @JsonIgnore
    private String ssn;

}
