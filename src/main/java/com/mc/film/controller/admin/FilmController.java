package com.mc.film.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mc.film.common.result.ResData;
import com.mc.film.common.result.ResultCodeEnum;
import com.mc.film.common.utils.CommonUtils;
import com.mc.film.common.utils.JwtUtil;
import com.mc.film.entity.Film;
import com.mc.film.entity.vo.FilmVo;
import com.mc.film.service.FilmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mr.Cheng
 * @since 2020/6/26
 */

@Api("影片管理")
@RestController
@RequestMapping("/admin/film")
@Slf4j
public class FilmController {

	private final FilmService filmService;

	public FilmController(FilmService filmService) {
		this.filmService = filmService;
	}

	@ApiOperation("显示所有影片")
	@GetMapping("/list")
	public ResData getFilmInfoList(@ApiParam(value = "当前页码", example = "1", required = true) @RequestParam int page,
								   @ApiParam(value = "每页记录数", example = "10", required = true) @RequestParam int limit,
								   @ApiParam(value = "中文名称搜索") @RequestParam String filmChiName,
								   HttpServletRequest request) {

		if (page <= 0 || limit <= 0) return ResData.error().message("参数不正确").data("");

		// 验证是否授权
		boolean flag = JwtUtil.checkJwtToken(request);
		if (!flag) return ResData.setResult(ResultCodeEnum.TOKEN_EXPIRED);

		Page<FilmVo> pageParam = new Page<>(page, limit);
		IPage<FilmVo> iPage = filmService.getFilmInfoList(pageParam, filmChiName);
		// 总数
		long total = iPage.getTotal();
		// 分页列表
		List<FilmVo> list = iPage.getRecords();

		Map<String, Object> map = new HashMap<>();
		map.put("total", total);
		map.put("filmList", list);
		return ResData.success().data(map);
	}

	@ApiOperation("添加影片")
	@PostMapping("/add")
	public ResData insertFilm(@ApiParam(value = "Film 对象", required = true) @RequestBody Film film,
							  HttpServletRequest request) {

		if (film.getFilmName() == null ||
				film.getFilmChiName() == null ||
				film.getFilmCountryId() == null ||
				film.getFilmLanguageId() == null ||
				film.getFilmTypeId() == null ||
				film.getFilmDuration() == null ||
				film.getFilmImdb() == null ||
				film.getFilmReleaseDate() == null) {
			return ResData.error().message("参数不正确");
		}

		film.setUid(CommonUtils.getUUID());

		// 验证是否授权
		boolean flag = JwtUtil.checkJwtToken(request);
		if (!flag) return ResData.setResult(ResultCodeEnum.TOKEN_EXPIRED);

		boolean isSave = filmService.save(film);
		if (!isSave) return ResData.success().message("保存失败").data(false);

		return ResData.success().message("保存成功").data(true);
	}

	@ApiOperation("修改影片")
	@PostMapping("/update")
	public ResData updateFilm(@ApiParam(value = "Film 对象", required = true) @RequestBody Film film,
							  HttpServletRequest request) {

		if (film.getUid() == null ||
				film.getFilmName() == null ||
				film.getFilmChiName() == null ||
				film.getFilmCountryId() == null ||
				film.getFilmLanguageId() == null ||
				film.getFilmTypeId() == null ||
				film.getFilmDuration() == null ||
				film.getFilmImdb() == null ||
				film.getFilmReleaseDate() == null) {
			return ResData.error().message("参数不正确");
		}

		// 验证是否授权
		boolean flag = JwtUtil.checkJwtToken(request);
		if (!flag) return ResData.setResult(ResultCodeEnum.TOKEN_EXPIRED);

		boolean isUpdate = filmService.updateById(film);
		if (!isUpdate) return ResData.success().message("修改失败").data(false);

		return ResData.success().message("修改成功").data(true);
	}

	@ApiOperation("删除影片")
	@GetMapping("/delete")
	public ResData deleteFilm(@ApiParam(value = "uid", required = true) @RequestParam String uid,
							  HttpServletRequest request) {

		if (StringUtils.isEmpty(uid)) return ResData.error().message("参数不正确");

		// 验证是否授权
		boolean flag = JwtUtil.checkJwtToken(request);
		if (!flag) return ResData.setResult(ResultCodeEnum.TOKEN_EXPIRED);

		boolean isDelete = filmService.removeById(uid);
		if (!isDelete) {
			return ResData.success().message("删除失败").data(false);
		}
		return ResData.success().message("删除成功").data(true);
	}
}
