package com.mc.film.controller.admin;

import com.mc.film.common.model.JwtInfo;
import com.mc.film.common.result.ResData;
import com.mc.film.common.utils.JwtUtil;
import com.mc.film.entity.vo.SysLoginQueryVo;
import com.mc.film.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api("用户管理")
@RequestMapping("/admin/user")
@Slf4j
public class SysUserController {

	private final SysUserService sysUserService;

	public SysUserController(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}


	@ApiOperation("系统登录")
	@PostMapping("/login")
	public ResData SysUserLogin(@ApiParam("账号密码") @RequestBody SysLoginQueryVo sysLoginQueryVo) {

		String token = sysUserService.sysLogin(sysLoginQueryVo);

		return ResData.success().message("登录成功").data("token", token);

	}

	@ApiOperation("根据 token 获取用户信息")
	@GetMapping("/info")
	public ResData getSysUserInfo(HttpServletRequest request) {

		JwtInfo jwtInfo = JwtUtil.getUserInfoByToken(request);

		return ResData.success().data(jwtInfo);

	}
}
