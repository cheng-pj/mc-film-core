package com.mc.film.service.impl;

import com.mc.film.entity.vo.FilmPosterVo;
import com.mc.film.mapper.admin.FilmPosterMapper;
import com.mc.film.service.FilmPosterService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Cheng
 * @since 2020/6/30
 */

@Service
public class FilmPosterServiceImpl implements FilmPosterService {

	private final FilmPosterMapper filmPosterMapper;

	public FilmPosterServiceImpl(FilmPosterMapper filmPosterMapper) {
		this.filmPosterMapper = filmPosterMapper;
	}

	@Override
	public List<FilmPosterVo> getFilmPosterList() {
		return filmPosterMapper.selectFilmPosterList();
	}
}
