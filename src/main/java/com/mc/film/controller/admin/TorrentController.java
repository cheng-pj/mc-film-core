package com.mc.film.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mc.film.common.result.ResData;
import com.mc.film.common.result.ResultCodeEnum;
import com.mc.film.common.utils.CommonUtils;
import com.mc.film.common.utils.JwtUtil;
import com.mc.film.entity.Torrent;
import com.mc.film.entity.vo.TorrentVo;
import com.mc.film.service.TorrentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mr.Cheng
 * @since 2020/6/30
 */

@Api("影片种子")
@RestController
@RequestMapping("/admin/torrent")
public class TorrentController {

	private final TorrentService torrentService;

	public TorrentController(TorrentService torrentService) {
		this.torrentService = torrentService;
	}

	@ApiOperation("影片种子列表")
	@GetMapping("/list")
	public ResData getTorrentList(@ApiParam(value = "当前页码", example = "1", required = true) @RequestParam int page,
								  @ApiParam(value = "每页记录数", example = "10", required = true) @RequestParam int limit,
								  @ApiParam(value = "搜索") @RequestParam String torrentName,
								  HttpServletRequest request) {
		if (page <= 0 || limit <= 0) return ResData.error().message("参数不正确").data("");

		// 验证是否授权
		boolean flag = JwtUtil.checkJwtToken(request);
		if (!flag) return ResData.setResult(ResultCodeEnum.TOKEN_EXPIRED);

		Page<TorrentVo> pageParam = new Page<>(page, limit);
		IPage<TorrentVo> iPage = torrentService.getTorrentInfoList(pageParam, torrentName);
		// 总数
		long total = iPage.getTotal();
		// 分页列表
		List<TorrentVo> list = iPage.getRecords();
		Map<String, Object> map = new HashMap<>();
		map.put("total", total);
		map.put("torrentList", list);
		return ResData.success().data(map);
	}

	@ApiOperation("添加种子")
	@PostMapping("/add")
	public ResData insertTorrent(@ApiParam(value = "Torrent 对象", required = true) @RequestBody Torrent torrent,
								 HttpServletRequest request) {

		if (torrent.getTorrentName() == null ||
				torrent.getTorrentUrl() == null ||
				torrent.getTorrentMagnet() == null) {
			return ResData.error().message("参数不正确");
		}

		torrent.setUid(CommonUtils.getUUID());

		// 验证是否授权
		boolean flag = JwtUtil.checkJwtToken(request);
		if (!flag) return ResData.setResult(ResultCodeEnum.TOKEN_EXPIRED);

		boolean isSave = torrentService.save(torrent);
		if (!isSave) return ResData.success().message("保存失败").data(false);

		return ResData.success().message("保存成功").data(true);
	}

	@ApiOperation("修改种子数据")
	@PostMapping("/update")
	public ResData updateFilm(@ApiParam(value = "Film 对象", required = true) @RequestBody Torrent torrent,
							  HttpServletRequest request) {

		if (torrent.getTorrentName() == null ||
				torrent.getTorrentUrl() == null ||
				torrent.getTorrentMagnet() == null) {
			return ResData.error().message("参数不正确");
		}

		// 验证是否授权
		boolean flag = JwtUtil.checkJwtToken(request);
		if (!flag) return ResData.setResult(ResultCodeEnum.TOKEN_EXPIRED);

		boolean isUpdate = torrentService.updateById(torrent);
		if (!isUpdate) return ResData.success().message("修改失败").data(false);

		return ResData.success().message("修改成功").data(true);
	}

	@ApiOperation("删除种子")
	@GetMapping("/delete")
	public ResData deleteTorrent(@ApiParam(value = "uid", required = true) @RequestParam String uid,
								 HttpServletRequest request) {

		if (StringUtils.isEmpty(uid)) return ResData.error().message("参数不正确");

		// 验证是否授权
		boolean flag = JwtUtil.checkJwtToken(request);
		if (!flag) return ResData.setResult(ResultCodeEnum.TOKEN_EXPIRED);

		boolean isDelete = torrentService.removeById(uid);
		if (!isDelete) return ResData.success().message("删除失败").data(false);

		return ResData.success().message("删除成功").data(true);
	}
}
