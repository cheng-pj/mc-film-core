package com.mc.film.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Mr.Cheng
 * @since 2020/6/27
 */

@Data
public class FilmTypeVo {

	private String uid;

	@ApiModelProperty(value = "影视类型")
	private String type;
}
