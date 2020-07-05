package com.mc.film.mapper.admin;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mc.film.entity.FilmType;
import com.mc.film.entity.vo.FilmTypeVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Mr.Cheng
 * @since 2020/6/29
 */

@Component
public interface FilmTypeMapper extends BaseMapper<FilmType>{

	/**
	 * 查询影片类型列表
	 * @return
	 */
	List<FilmTypeVo> selectFilmTypeList();

}
