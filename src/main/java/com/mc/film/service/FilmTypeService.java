package com.mc.film.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mc.film.entity.FilmType;
import com.mc.film.entity.vo.FilmTypeVo;

import java.util.List;

/**
 * @author Mr.Cheng
 * @since 2020/6/29
 */

public interface FilmTypeService extends IService<FilmType> {

	/**
	 * 查询影片类型列表
	 *
	 * @return
	 */
	List<FilmTypeVo> getFilmTypeList();
}
