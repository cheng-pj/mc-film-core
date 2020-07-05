package com.mc.film.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Mr.Cheng
 * @since 2020/6/27
 */

@Data
public class TorrentVo {

	private String uid;

	@ApiModelProperty(value = "种子名称")
	private String torrentName;

	@ApiModelProperty(value = "种子url")
	private String torrentUrl;

	@ApiModelProperty(value = "磁力链接")
	private String torrentMagnet;

	@ApiModelProperty(value = "关联影片id")
	private String filmId;

	@ApiModelProperty(value = "影片中文名字")
	private String filmChiName;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "更新时间")
	private Date updateTime;
}
