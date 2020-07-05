package com.mc.film.mapper.admin;

import com.mc.film.entity.vo.FilmCountryVo;
import com.mc.film.entity.vo.FilmLanguageVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Mr.Cheng
 * @since 2020/6/30
 */

@Component
public interface FilmLanguageMapper {

	/**
	 * 查询影片语言列表
	 *
	 * @return
	 */
	List<FilmLanguageVo> selectFilmLanguageList();
}
