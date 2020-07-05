package com.mc.film.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mc.film.entity.Film;
import com.mc.film.entity.vo.FilmVo;


/**
 * @author Mr.Cheng
 * @since 2020/6/26
 */
public interface FilmService extends IService<Film> {

	/**
	 * 分页查询影片列表
	 *
	 * @param pageParam
	 * @return
	 */
	IPage<FilmVo> getFilmInfoList(Page<FilmVo> pageParam, String searchKey);
}
