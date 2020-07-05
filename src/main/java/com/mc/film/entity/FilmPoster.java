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
@TableName("mc_film_poster")
public class FilmPoster extends BaseEntity {

	@ApiModelProperty(value = "海报名称")
	@TableField(value = "poster_name")
	private String posterName;

	@ApiModelProperty(value = "海报地址")
	@TableField(value = "poster_url")
	private String posterUrl;

}
