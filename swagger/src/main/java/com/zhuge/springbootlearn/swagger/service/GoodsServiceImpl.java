package com.zhuge.springbootlearn.swagger.service;

import com.zhuge.springbootlearn.swagger.dao.GoodsMapper;
import com.zhuge.springbootlearn.swagger.domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Title: GoodsServiceImpl
 * @Description:
 * @author: zhuge
 * @date: 2018/12/31 15:03
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void insert(Goods goods) throws Exception {
        goodsMapper.insert(goods);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void delete(Integer id) throws Exception {
        goodsMapper.deleteByPrimaryKey(id);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void update(Goods goods) throws Exception {
        goodsMapper.updateByPrimaryKey(goods);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public Goods query(Integer id) throws Exception {
        return goodsMapper.selectByPrimaryKey(id);
    }
}
