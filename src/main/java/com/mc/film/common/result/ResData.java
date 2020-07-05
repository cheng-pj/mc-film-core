package com.mc.film.common.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@ApiModel("返回结果")
public class ResData {

	@ApiModelProperty("是否成功")
	private Boolean success;

	@ApiModelProperty("返回码")
	private Integer code;

	@ApiModelProperty("返回消息")
	private String message;

	@ApiModelProperty("返回数据")
	private Object data;


	public static ResData success() {
		ResData resData = new ResData();
		resData.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
		resData.setCode(ResultCodeEnum.SUCCESS.getCode());
		resData.setMessage(ResultCodeEnum.SUCCESS.getMessage());
		return resData;
	}

	public static ResData error() {
		ResData resData = new ResData();
		resData.setSuccess(ResultCodeEnum.UNKNOWN_ERROR.getSuccess());
		resData.setCode(ResultCodeEnum.UNKNOWN_ERROR.getCode());
		resData.setMessage(ResultCodeEnum.UNKNOWN_ERROR.getMessage());
		return resData;
	}

	public static ResData setResult(ResultCodeEnum result) {
		ResData resData = new ResData();
		resData.setSuccess(result.getSuccess());
		resData.setCode(result.getCode());
		resData.setMessage(result.getMessage());
		return resData;
	}

	public ResData success(Boolean success) {
		this.setSuccess(success);
		return this;
	}

	public ResData message(String message) {
		this.setMessage(message);
		return this;
	}

	public ResData code(Integer code) {
		this.setCode(code);
		return this;
	}

	public ResData data(Object value) {
		this.setData(value);
		return this;
	}

	public ResData data(String key, Object value) {
		Map<String, Object> map = new HashMap<>();
		map.put(key, value);
		this.setData(map);
		return this;
	}

	public ResData data(Map<String, Object> data) {
		this.setData(data);
		return this;
	}
}
