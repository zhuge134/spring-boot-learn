package com.zhuge.springbootlearn.swagger.dao;

import com.zhuge.springbootlearn.swagger.domain.Goods;
import org.springframework.stereotype.Repository;

/**
 * @Title: GoodsMapper
 * @Description:
 * @author: zhuge
 * @date: 2018/12/31 14:59
 */
@Repository
public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}