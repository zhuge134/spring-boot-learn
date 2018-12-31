package com.zhuge.springbootlearn.swagger.service;

import com.zhuge.springbootlearn.swagger.domain.Goods;

public interface GoodsService {
    void insert(Goods goods) throws Exception;

    void delete(Integer id) throws Exception;

    void update(Goods goods) throws Exception;

    Goods query(Integer id) throws Exception;
}
