package com.mc.film.controller.admin;

import com.mc.film.common.result.ResData;
import com.mc.film.common.result.ResultCodeEnum;
import com.mc.film.common.utils.CommonUtils;
import com.mc.film.common.utils.JwtUtil;
import com.mc.film.entity.FilmCountry;
import com.mc.film.entity.vo.FilmCountryVo;
import com.mc.film.service.FilmCountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Mr.Cheng
 * @since 2020/6/30
 */

@Api("影片国家/地区")
@RestController
@RequestMapping("/admin/country")
public class FilmCountryController {

	private final FilmCountryService filmCountryService;

	public FilmCountryController(FilmCountryService filmCountryService) {
		this.filmCountryService = filmCountryService;
	}

	@ApiOperation("国家地区下拉菜单")
	@GetMapping("/option")
	public ResData getCountryOption(HttpServletRequest request) {

		// 验证是否授权
		boolean flag = JwtUtil.checkJwtToken(request);

		if (!flag) return ResData.setResult(ResultCodeEnum.TOKEN_EXPIRED);

		List<FilmCountryVo> list = filmCountryService.getFilmCountryList();

		return ResData.success().data(list);
	}

	@ApiOperation("国家/地区列表")
	@GetMapping("/list")
	public ResData getCountryList(HttpServletRequest request) {

		// 验证是否授权
		boolean flag = JwtUtil.checkJwtToken(request);

		if (!flag) return ResData.setResult(ResultCodeEnum.TOKEN_EXPIRED);

		List<FilmCountry> list = filmCountryService.list();

		return ResData.success().data(list);
	}

	@ApiOperation("添加国家/地区")
	@PostMapping("/add")
	public ResData insertFilmCountry(@ApiParam(value = "FilmCountry 对象", required = true) @RequestBody FilmCountry filmCountry,
									 HttpServletRequest request) {

		if (filmCountry.getFilmCountry() == null) return ResData.error().message("参数不正确");

		filmCountry.setUid(CommonUtils.getUUID());

		// 验证是否授权
		boolean flag = JwtUtil.checkJwtToken(request);
		if (!flag) return ResData.setResult(ResultCodeEnum.TOKEN_EXPIRED);

		boolean isSave = filmCountryService.save(filmCountry);
		if (!isSave) return ResData.success().message("保存失败").data(false);

		return ResData.success().message("保存成功").data(true);
	}

	@ApiOperation("修改种子数据")
	@PostMapping("/update")
	public ResData updateFilmCountry(@ApiParam(value = "FilmCountry 对象", required = true) @RequestBody FilmCountry filmCountry,
							  HttpServletRequest request) {

		if (filmCountry.getFilmCountry() == null) return ResData.error().message("参数不正确");

		// 验证是否授权
		boolean flag = JwtUtil.checkJwtToken(request);
		if (!flag) return ResData.setResult(ResultCodeEnum.TOKEN_EXPIRED);

		boolean isUpdate = filmCountryService.updateById(filmCountry);
		if (!isUpdate) return ResData.success().message("修改失败").data(false);

		return ResData.success().message("修改成功").data(true);
	}

	@ApiOperation("删除国家/地区")
	@GetMapping("/delete")
	public ResData deleteFilmCountry(@ApiParam(value = "uid", required = true) @RequestParam String uid,
									 HttpServletRequest request) {

		if (StringUtils.isEmpty(uid)) return ResData.error().message("参数不正确");

		// 验证是否授权
		boolean flag = JwtUtil.checkJwtToken(request);
		if (!flag) return ResData.setResult(ResultCodeEnum.TOKEN_EXPIRED);

		boolean isDelete = filmCountryService.removeById(uid);
		if (!isDelete) {
			return ResData.success().message("删除失败").data(false);
		}
		return ResData.success().message("删除成功").data(true);
	}
}
