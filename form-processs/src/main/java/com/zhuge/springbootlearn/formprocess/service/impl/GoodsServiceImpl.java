package com.zhuge.springbootlearn.formprocess.service.impl;

import com.zhuge.springbootlearn.formprocess.dao.GoodsMapper;
import com.zhuge.springbootlearn.formprocess.domain.Goods;
import com.zhuge.springbootlearn.formprocess.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    @Transactional(readOnly = true, rollbackFor = {Exception.class})
    public List<Goods> queryAll() throws Exception {
        return goodsMapper.queryAll();
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void add(Goods goods) throws Exception {
        goodsMapper.insert(goods);
    }
}
