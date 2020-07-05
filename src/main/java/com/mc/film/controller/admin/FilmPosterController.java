package com.mc.film.controller.admin;

import com.mc.film.common.result.ResData;
import com.mc.film.common.utils.JwtUtil;
import com.mc.film.entity.vo.FilmPosterVo;
import com.mc.film.service.FilmPosterService;
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

@Api("影片海报管理")
@RestController
@RequestMapping("/admin/poster")
public class FilmPosterController {

	private final FilmPosterService filmPosterService;

	public FilmPosterController(FilmPosterService filmPosterService) {
		this.filmPosterService = filmPosterService;
	}

	@ApiOperation("电影海报列表")
	@GetMapping("/list")
	public ResData getFilmPosterList(HttpServletRequest request) {
		// 验证是否授权
		boolean flag = JwtUtil.checkJwtToken(request);

		if (!flag) return ResData.error().message("登录未授权请重新登录").data("");

		List<FilmPosterVo> list = filmPosterService.getFilmPosterList();

		return ResData.success().data(list);
	}

}
