package com.mc.film.mapper.admin;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mc.film.entity.FilmCountry;
import com.mc.film.entity.vo.FilmCountryVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Mr.Cheng
 * @since 2020/6/30
 */

@Component
public interface FilmCountryMapper extends BaseMapper<FilmCountry> {

	/**
	 * 查询影片地区 option
	 * @return
	 */
	List<FilmCountryVo> selectFilmCountryList();
}
