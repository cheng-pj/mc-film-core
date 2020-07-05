package com.mc.film.common.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum ResultCodeEnum {
	SUCCESS(true, 20000, "成功"),

	UNKNOWN_ERROR(false, 40000, "未知错误"),
	ILLEGAL_CALLBACK_REQUEST_ERROR(false, 40001, "非法回调请求"),
	PARAM_ERROR(false, 40002, "参数错误"),
	URL_ENCODE_ERROR(false, 40003, "URL编码失败"),

	FILE_UPLOAD_FAIL(false, 30000, "文件上传失败"),
	FILE_DELETE_FAIL(false, 30001, "文件删除失败"),
	EXCEL_DATA_IMPORT_FAIL(false, 30002, "Excel表格导出失败"),

	ACCOUNT_NO_EXIST(false, 50000, "账号不存在"),
	PASSWORD_ERROR(false, 50001, "密码错误"),
	LOGIN_ERROR(false, 50002, "登录失败"),
	FETCH_USER_INFO_FAIL(false, 50003, "获取用户信息失败"),
	FETCH_ACCESS_TOKEN_FAIL(false, 50004, "获取accessToken失败"),

	SQL_ERROR(false, 50005, "sql语法错误"),
	SQL_BASE_ERROR(false, 50006, "数据库连接失败"),
	JSON_PARSE_ERROR(true, 50007, "json解析异常"),
	TOKEN_ILLEGAL(true, 50008, "非法令牌"),
	TOKEN_EXPIRED(true, 50009, "登录未授权请重新登录");

	private Boolean success;

	private Integer code;

	private String message;
}
