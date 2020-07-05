package com.mc.film.mapper.admin;

import com.mc.film.entity.vo.FilmPosterVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Mr.Cheng
 * @since 2020/6/30
 */

@Component
public interface FilmPosterMapper {

	/**
	 * 查询影片海报列表
	 *
	 * @return
	 */
	List<FilmPosterVo> selectFilmPosterList();
}
