package com.mc.film.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mc.film.entity.Film;
import com.mc.film.entity.vo.FilmVo;
import com.mc.film.mapper.admin.FilmMapper;
import com.mc.film.service.FilmService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Cheng
 * @since 2020/6/26
 */
//
@Service
public class FilmServiceImpl extends ServiceImpl<FilmMapper, Film> implements FilmService {

	private final FilmMapper filmMapper;

	public FilmServiceImpl(FilmMapper filmMapper) {
		this.filmMapper = filmMapper;
	}


	@Override
	public IPage<FilmVo> getFilmInfoList(Page<FilmVo> pageParam, String searchKey) {

		QueryWrapper<FilmVo> queryWrapper = new QueryWrapper<>();
		// key 为空普通搜索 不为空模糊查询
		List<FilmVo> list = filmMapper.selectFilmList(pageParam, queryWrapper, searchKey);
		return pageParam.setRecords(list);
	}
}
