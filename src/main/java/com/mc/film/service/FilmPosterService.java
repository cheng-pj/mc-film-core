package com.mc.film.service;

import com.mc.film.entity.vo.FilmPosterVo;

import java.util.List;

/**
 * @author Mr.Cheng
 * @since 2020/6/30
 */

public interface FilmPosterService {

	/**
	 * 查询影片海报列表
	 *
	 * @return
	 */
	List<FilmPosterVo> getFilmPosterList();
}
