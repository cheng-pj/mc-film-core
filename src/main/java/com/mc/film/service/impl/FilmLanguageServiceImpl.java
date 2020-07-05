package com.mc.film.service.impl;

import com.mc.film.entity.vo.FilmLanguageVo;
import com.mc.film.mapper.admin.FilmLanguageMapper;
import com.mc.film.service.FilmLanguageService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Cheng
 * @since 2020/6/30
 */

@Service
public class FilmLanguageServiceImpl implements FilmLanguageService {

	private final FilmLanguageMapper filmLanguageMapper;

	public FilmLanguageServiceImpl(FilmLanguageMapper filmLanguageMapper) {
		this.filmLanguageMapper = filmLanguageMapper;
	}

	@Override
	public List<FilmLanguageVo> getFilmLanguageList() {
		return filmLanguageMapper.selectFilmLanguageList();
	}
}
