package com.mc.film.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mc.film.entity.Torrent;
import com.mc.film.entity.vo.TorrentVo;
import com.mc.film.mapper.admin.TorrentMapper;
import com.mc.film.service.TorrentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Cheng
 * @since 2020/6/30
 */

@Service
public class TorrentServiceImpl extends ServiceImpl<TorrentMapper, Torrent> implements TorrentService {

	private final TorrentMapper torrentMapper;

	public TorrentServiceImpl(TorrentMapper torrentMapper) {
		this.torrentMapper = torrentMapper;
	}

	@Override
	public IPage<TorrentVo> getTorrentInfoList(Page<TorrentVo> pageParam, String searchKey ) {

		QueryWrapper<TorrentVo> queryWrapper = new QueryWrapper<>();
		// key 为空普通搜索 不为空模糊查询
		List<TorrentVo> list =  torrentMapper.selectTorrentList(pageParam, queryWrapper, searchKey);
		return pageParam.setRecords(list);
	}
}
