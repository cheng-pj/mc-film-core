package com.mc.film.service;

import com.mc.film.entity.vo.FilmLanguageVo;

import java.util.List;

/**
 * @author Mr.Cheng
 * @since 2020/6/30
 */

public interface FilmLanguageService {

	/**
	 * 查询影片语言列表
	 *
	 * @return
	 */
	List<FilmLanguageVo> getFilmLanguageList();

}
