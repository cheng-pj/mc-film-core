package com.mc.film.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mc.film.entity.FilmCountry;
import com.mc.film.entity.vo.FilmCountryVo;
import com.mc.film.mapper.admin.FilmCountryMapper;
import com.mc.film.service.FilmCountryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Cheng
 * @since 2020/6/30
 */

@Service
public class FilmCountryServiceImpl extends ServiceImpl<FilmCountryMapper, FilmCountry> implements FilmCountryService {

	private final FilmCountryMapper filmCountryMapper;

	public FilmCountryServiceImpl(FilmCountryMapper filmCountryMapper) {
		this.filmCountryMapper = filmCountryMapper;
	}

	@Override
	public List<FilmCountryVo> getFilmCountryList() {
		return filmCountryMapper.selectFilmCountryList();
	}
}
