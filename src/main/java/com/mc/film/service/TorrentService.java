package com.mc.film.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mc.film.entity.Torrent;
import com.mc.film.entity.vo.TorrentVo;

/**
 * @author Mr.Cheng
 * @since 2020/6/30
 */

public interface TorrentService extends IService<Torrent> {

	/**
	 * 分页查询种子列表
	 * @param pageParam
	 * @param searchKey
	 * @return
	 */
	IPage<TorrentVo> getTorrentInfoList(Page<TorrentVo> pageParam, String searchKey);

}
