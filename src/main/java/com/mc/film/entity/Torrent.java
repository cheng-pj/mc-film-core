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
@TableName("mc_film_torrent")
public class Torrent extends BaseEntity {

	@ApiModelProperty(value = "种子名称")
	@TableField(value = "torrent_name")
	private String torrentName;

	@ApiModelProperty(value = "种子路径")
	@TableField(value = "torrent_url")
	private String torrentUrl;

	@ApiModelProperty(value = "种子链接")
	@TableField(value = "torrent_magnet")
	private String torrentMagnet;

	@ApiModelProperty(value = "影片id")
	@TableField(value = "film_id")
	private String filmId;

}
