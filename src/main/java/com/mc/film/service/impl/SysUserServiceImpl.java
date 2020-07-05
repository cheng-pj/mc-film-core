package com.mc.film.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mc.film.common.exception.MyException;
import com.mc.film.common.result.ResultCodeEnum;
import com.mc.film.common.model.JwtInfo;
import com.mc.film.common.utils.JwtUtil;
import com.mc.film.common.utils.MD5Util;
import com.mc.film.mapper.admin.SysUserMapper;
import com.mc.film.entity.SysUser;
import com.mc.film.entity.vo.SysLoginQueryVo;
import com.mc.film.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SysUserServiceImpl implements SysUserService {

	private final SysUserMapper sysUserMapper;

	public SysUserServiceImpl(SysUserMapper sysUserMapper) {
		this.sysUserMapper = sysUserMapper;
	}

	@Override
	public String sysLogin(SysLoginQueryVo sysLoginQueryVo) {

		// 获取 SysLoginQueryVo 对象的值
		String username = sysLoginQueryVo.getUsername();
		String password = sysLoginQueryVo.getPassword();

		QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();

		//验证参数
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			throw new MyException(ResultCodeEnum.PARAM_ERROR);
		}

		// 验证账号是否存在
		queryWrapper.eq("username", username);
		SysUser sysUser = sysUserMapper.selectOne(queryWrapper);
		
		if (sysUser == null) {
			throw new MyException(ResultCodeEnum.ACCOUNT_NO_EXIST);
		}

		// 验证密码是否正确
		if (!MD5Util.encrypt(password).equals(sysUser.getPassword())) {
			throw new MyException(ResultCodeEnum.PASSWORD_ERROR);
		}

		JwtInfo info = new JwtInfo();
		info.setId(sysUser.getUid());
		info.setUsername(sysUser.getUsername());
		info.setNickname(sysUser.getNickname());

		String token = JwtUtil.setJwtToken(info, 3600);	// 60分钟
		return token;
	}
}