package com.mc.film.mapper.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mc.film.entity.Film;
import com.mc.film.entity.vo.FilmVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Mr.Cheng
 * @since 2020/6/26
 */

@Component
public interface FilmMapper extends BaseMapper<Film> {

	/**
	 * 分页查询影片列表
	 * @param pageParam
	 * @param queryWrapper
	 * @param filmChiName
	 * @return
	 */
	List<FilmVo> selectFilmList(Page<FilmVo> pageParam, @Param(Constants.WRAPPER) QueryWrapper<FilmVo> queryWrapper, String filmChiName);
}
