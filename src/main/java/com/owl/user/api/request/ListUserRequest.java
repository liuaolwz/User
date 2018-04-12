package com.owl.user.api.request;

import com.owl.user.enums.Gender;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListUserRequest {
    private Integer pageSize=10;
    private Integer pageNum=1;
    @ApiModelProperty(value = "姓名查询条件，模糊查询")
    private String name;
    @ApiModelProperty(value = "年龄高于该值用户")
    private Integer ageStart;
    @ApiModelProperty(value = "年龄低于该值用户")
    private Integer ageEnd;
    @ApiModelProperty(value = "性别条件")
    private Gender gender;
    @ApiModelProperty(value = "创建时间晚于")
    private LocalDateTime createStart;
    @ApiModelProperty(value = "创建时间早于")
    private LocalDateTime createEnd;
}
