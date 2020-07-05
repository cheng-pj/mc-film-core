package com.mc.film.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mc.film.common.model.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author Mr.Cheng
 * @since 2020/6/26
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@TableName("mc_film_country")
public class FilmCountry extends BaseEntity {

	@ApiModelProperty(value = "国家")
	@TableField(value = "film_country")
	private String filmCountry;
}
