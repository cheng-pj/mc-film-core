package com.mc.film.common.handler;

import com.mc.film.common.exception.MyException;
import com.mc.film.common.result.ResData;
import com.mc.film.common.result.ResultCodeEnum;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

/**
 * @author Mr.Cheng
 * @since 2020/6/14
 */

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResData error(Exception e) {

		log.error(LogHandler.getExceptionMsg(e));

		return ResData.error();
	}

	/**
	 * SQL 语法异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(BadSqlGrammarException.class)
	@ResponseBody
	public ResData error(BadSqlGrammarException e) {

		log.error(LogHandler.getExceptionMsg(e));

		return ResData.setResult(ResultCodeEnum.SQL_ERROR);
	}

	/**
	 * 数据库连接异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(SQLException.class)
	@ResponseBody
	public ResData error(SQLException e) {

		log.error(LogHandler.getExceptionMsg(e));

		return ResData.setResult(ResultCodeEnum.SQL_BASE_ERROR);
	}

	/**
	 * 约束异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(DuplicateKeyException.class)
	@ResponseBody
	public ResData error(DuplicateKeyException e) {

		log.error(LogHandler.getExceptionMsg(e));

		return ResData.error().message("表中已有数据");
	}

	/**
	 * JSON 解析异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseBody
	public ResData error(HttpMessageNotReadableException e) {

		log.error(LogHandler.getExceptionMsg(e));

		return ResData.setResult(ResultCodeEnum.JSON_PARSE_ERROR);
	}

	/**
	 * token 过期异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(ExpiredJwtException.class)
	@ResponseBody
	public ResData error(ExpiredJwtException e) {

		log.error("解析 token 失败 -> " + LogHandler.getExceptionMsg(e));

		return ResData.setResult(ResultCodeEnum.TOKEN_EXPIRED);
	}

	/**
	 * 自定义异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(MyException.class)
	@ResponseBody
	public ResData error(MyException e) {

		log.error(LogHandler.getExceptionMsg(e));

		return ResData.error().message(e.getMessage()).code(e.getCode());
	}
}
