package com.mc.film.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mc.film.entity.FilmType;
import com.mc.film.entity.vo.FilmTypeVo;
import com.mc.film.mapper.admin.FilmTypeMapper;
import com.mc.film.service.FilmTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Cheng
 * @since 2020/6/29
 */

@Service
public class FilmTypeServiceImpl extends ServiceImpl<FilmTypeMapper, FilmType> implements FilmTypeService {

	private final FilmTypeMapper filmTypeMapper;

	public FilmTypeServiceImpl(FilmTypeMapper filmTypeMapper) {
		this.filmTypeMapper = filmTypeMapper;
	}

	@Override
	public List<FilmTypeVo> getFilmTypeList() {

		return filmTypeMapper.selectFilmTypeList();
	}

}
