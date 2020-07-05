package com.mc.film.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Mr.Cheng
 * @since 2020/6/17
 */

@Data
@ApiModel("查询账号密码")
public class SysLoginQueryVo {

	@ApiModelProperty("用户账号")
	private String username;

	@ApiModelProperty("用户密码")
	private String password;

}
