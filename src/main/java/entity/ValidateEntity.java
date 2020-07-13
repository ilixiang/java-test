package entity;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ValidateEntity {
    @NotNull(message = "描述信息不能为空")
    private String desc;

    @Email(message = "Email格式错误")
    private String email;

    private List<@Max(value = 5, message = "数字不能大于5") Integer> list;

}
