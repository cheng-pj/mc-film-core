package com.mc.film.controller.admin;

import com.mc.film.common.result.ResData;
import com.mc.film.common.utils.JwtUtil;
import com.mc.film.entity.vo.FilmLanguageVo;
import com.mc.film.service.FilmLanguageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Mr.Cheng
 * @since 2020/6/30
 */

@Api("影片语言")
@RestController
@RequestMapping("/admin/language")
public class FilmLanguageController {

	private final FilmLanguageService filmLanguageService;

	public FilmLanguageController(FilmLanguageService filmLanguageService) {
		this.filmLanguageService = filmLanguageService;
	}

	@ApiOperation("电影语言列表")
	@GetMapping("/list")
	public ResData getLanguageList(HttpServletRequest request) {
		// 验证是否授权
		boolean flag = JwtUtil.checkJwtToken(request);

		if (!flag) return ResData.error().message("登录未授权请重新登录").data("");

		List<FilmLanguageVo> list = filmLanguageService.getFilmLanguageList();

		return ResData.success().data(list);
	}
}
