package com.owl.user.api.request;

import com.owl.user.enums.Gender;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveOrUpdateUserRequest {
    @NotBlank(message = "姓名不能为空")
    @ApiModelProperty(value = "姓名")
    private String name;
    @NotNull
    @ApiModelProperty(value = "年龄")
    private Integer age;
    @NotNull
    @ApiModelProperty(value = "性别")
    private Gender gender;
}
