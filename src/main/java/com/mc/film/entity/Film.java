package com.mc.film.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.mc.film.common.model.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author Mr.Cheng
 * @since 2020/6/26
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@TableName("mc_film")
public class Film extends BaseEntity {

	@ApiModelProperty(value = "原名")
	@TableField(value = "film_name")
	private String filmName;

	@ApiModelProperty(value = "中文名")
	@TableField(value = "film_chi_name")
	private String filmChiName;

	@ApiModelProperty(value = "发布日期")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@TableField(value = "film_release_date")
	private Date filmReleaseDate;

	@ApiModelProperty(value = "时长", example = "120")
	@TableField(value = "film_duration")
	private Integer filmDuration;

	@ApiModelProperty(value = "imdb 编号", example = "tt123456")
	@TableField(value = "film_imdb")
	private String filmImdb;

	@ApiModelProperty(value = "豆瓣评分", example = "5.0")
	@TableField(value = "film_douban")
	private Float filmDouban;

	@ApiModelProperty(value = "介绍")
	@TableField(value = "film_introduce")
	private String filmIntroduce;

	@ApiModelProperty(value = "地区 uid")
	@TableField(value = "film_country_id")
	private String filmCountryId;

	@ApiModelProperty(value = "语言 uid")
	@TableField(value = "film_language_id")
	private String filmLanguageId;

	@ApiModelProperty(value = "类型 uid")
	@TableField(value = "film_type_id")
	private String filmTypeId;

	@ApiModelProperty(value = "海报 uid")
	@TableField(value = "film_poster_id")
	private String filmPosterId;
}
