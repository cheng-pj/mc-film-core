package com.mc.film.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mc.film.entity.FilmCountry;
import com.mc.film.entity.vo.FilmCountryVo;

import java.util.List;

/**
 * @author Mr.Cheng
 * @since 2020/6/30
 */

public interface FilmCountryService extends IService<FilmCountry> {

	/**
	 * 查询影片地区 option
	 * @return
	 */
	List<FilmCountryVo> getFilmCountryList();
}
