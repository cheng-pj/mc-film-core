package com.mc.film.controller.admin;

import com.mc.film.common.result.ResData;
import com.mc.film.common.utils.JwtUtil;
import com.mc.film.entity.vo.FilmTypeVo;
import com.mc.film.service.FilmTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Mr.Cheng
 * @since 2020/6/29
 */

@Api("种子管理")
@RestController
@RequestMapping("/admin/type")
public class FilmTypeController {

	private final FilmTypeService filmTypeService;

	public FilmTypeController(FilmTypeService filmTypeService) {
		this.filmTypeService = filmTypeService;
	}

	@ApiOperation("电影类型列表")
	@GetMapping("/list")
	public ResData getTypeList(HttpServletRequest request) {
		// 验证是否授权
		boolean flag = JwtUtil.checkJwtToken(request);

		if (!flag) return ResData.error().message("登录未授权请重新登录").data("");

		List<FilmTypeVo> list = filmTypeService.getFilmTypeList();

		return ResData.success().data(list);
	}

}
