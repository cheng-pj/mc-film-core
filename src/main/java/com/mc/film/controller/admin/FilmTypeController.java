package com.mc.film.controller.admin;

import com.mc.film.common.result.ResData;
import com.mc.film.common.result.ResultCodeEnum;
import com.mc.film.common.utils.CommonUtils;
import com.mc.film.common.utils.JwtUtil;
import com.mc.film.entity.FilmType;
import com.mc.film.entity.vo.FilmTypeVo;
import com.mc.film.service.FilmTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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

	@ApiOperation("影视类型下拉菜单")
	@GetMapping("/option")
	public ResData getCountryOption(HttpServletRequest request) {

		// 验证是否授权
		boolean flag = JwtUtil.checkJwtToken(request);

		if (!flag) return ResData.setResult(ResultCodeEnum.TOKEN_EXPIRED);

		List<FilmTypeVo> list = filmTypeService.getFilmTypeList();

		return ResData.success().data(list);
	}

	@ApiOperation("电影类型列表")
	@GetMapping("/list")
	public ResData getTypeList(HttpServletRequest request) {
		// 验证是否授权
		boolean flag = JwtUtil.checkJwtToken(request);

		if (!flag) return ResData.setResult(ResultCodeEnum.TOKEN_EXPIRED);

		List<FilmType> list = filmTypeService.list();

		return ResData.success().data(list);
	}

	@ApiOperation("添加类型")
	@PostMapping("/add")
	public ResData insertFilmType(@ApiParam(value = "FilmType 对象", required = true) @RequestBody FilmType filmType,
								  HttpServletRequest request) {

		if (filmType.getType() == null) return ResData.error().message("参数不正确");

		filmType.setUid(CommonUtils.getUUID());

		// 验证是否授权
		boolean flag = JwtUtil.checkJwtToken(request);
		if (!flag) return ResData.setResult(ResultCodeEnum.TOKEN_EXPIRED);

		boolean isSave = filmTypeService.save(filmType);
		if (!isSave) return ResData.success().message("保存失败").data(false);

		return ResData.success().message("保存成功").data(true);
	}

	@ApiOperation("修改类型")
	@PostMapping("/update")
	public ResData updateFilmType(@ApiParam(value = "FilmType 对象", required = true) @RequestBody FilmType filmType,
								  HttpServletRequest request) {

		if (filmType.getType() == null) return ResData.error().message("参数不正确");

		// 验证是否授权
		boolean flag = JwtUtil.checkJwtToken(request);
		if (!flag) return ResData.setResult(ResultCodeEnum.TOKEN_EXPIRED);

		boolean isUpdate = filmTypeService.updateById(filmType);
		if (!isUpdate) return ResData.success().message("修改失败").data(false);

		return ResData.success().message("修改成功").data(true);
	}

	@ApiOperation("删除类型")
	@GetMapping("/delete")
	public ResData deleteFilmCountry(@ApiParam(value = "uid", required = true) @RequestParam String uid,
									 HttpServletRequest request) {

		if (StringUtils.isEmpty(uid)) return ResData.error().message("参数不正确");

		// 验证是否授权
		boolean flag = JwtUtil.checkJwtToken(request);
		if (!flag) return ResData.setResult(ResultCodeEnum.TOKEN_EXPIRED);

		boolean isDelete = filmTypeService.removeById(uid);
		if (!isDelete) {
			return ResData.success().message("删除失败").data(false);
		}
		return ResData.success().message("删除成功").data(true);
	}
}
