package com.mc.film.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Mr.Cheng
 * @since 2020/6/27
 */

@Data
public class FilmLanguageVo {

	private String uid;

	@ApiModelProperty(value = "语言")
	private String language;
}
