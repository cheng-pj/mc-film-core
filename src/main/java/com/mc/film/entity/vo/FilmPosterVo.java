package com.mc.film.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Mr.Cheng
 * @since 2020/6/27
 */

@Data
public class FilmPosterVo {

	private String uid;

	@ApiModelProperty(value = "海报名称")
	private String posterName;

	@ApiModelProperty(value = "海报地址")
	private String posterUrl;

}
