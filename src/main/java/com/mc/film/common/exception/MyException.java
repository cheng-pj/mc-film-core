package com.mc.film.common.exception;

import com.mc.film.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * @author Mr.Cheng
 * @since 2020/6/15
 */

@Data
public class MyException extends RuntimeException {

	private Integer code;

	public MyException(String message, Integer code) {
		super(message);
		this.code = code;
	}

	public MyException(ResultCodeEnum resultCodeEnum) {
		super(resultCodeEnum.getMessage());
		this.code = resultCodeEnum.getCode();
	}
}
