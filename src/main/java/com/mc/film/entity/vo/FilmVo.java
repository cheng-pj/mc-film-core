package com.mc.film.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author Mr.Cheng
 * @since 2020/6/27
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FilmVo {

	private String uid;

	@ApiModelProperty(value = "原名")
	private String filmName;

	@ApiModelProperty(value = "中文名")
	private String filmChiName;

	@ApiModelProperty(value = "发布日期")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date filmReleaseDate;

	@ApiModelProperty(value = "时长")
	private Integer filmDuration;

	@ApiModelProperty(value = "imdb 编号")
	private String filmImdb;

	@ApiModelProperty(value = "豆瓣评分")
	private Float filmDouban;

	@ApiModelProperty(value = "介绍")
	private String filmIntroduce;

	@ApiModelProperty(value = "国家")
	private FilmCountryVo filmCountry;

	@ApiModelProperty(value = "语言")
	private FilmLanguageVo filmLanguage;

	@ApiModelProperty(value = "类型")
	private FilmTypeVo filmType;

	@ApiModelProperty(value = "海报地址")
	private FilmPosterVo filmPoster;
}
