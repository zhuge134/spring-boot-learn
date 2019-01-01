package com.zhuge.springbootlearn.formprocess.service;

import com.zhuge.springbootlearn.formprocess.domain.Goods;

import java.util.List;

public interface GoodsService {

    List<Goods> queryAll() throws Exception;

    void add(Goods goods) throws Exception;
}
