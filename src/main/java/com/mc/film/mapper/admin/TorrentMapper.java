package com.mc.film.mapper.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mc.film.entity.Torrent;
import com.mc.film.entity.vo.TorrentVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Mr.Cheng
 * @since 2020/6/30
 */

@Component
public interface TorrentMapper extends BaseMapper<Torrent> {

	/**
	 * 分页查询种子列表
	 * @param pageParam
	 * @param queryWrapper
	 * @param torrentName
	 * @return
	 */
	List<TorrentVo> selectTorrentList(Page<TorrentVo> pageParam, @Param(Constants.WRAPPER) QueryWrapper<TorrentVo> queryWrapper, String torrentName);


}
