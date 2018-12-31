package com.zhuge.springbootlearn.swagger.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhuge.springbootlearn.swagger.domain.Goods;
import com.zhuge.springbootlearn.swagger.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


/**
 * @Title: GoodsController
 * @Description:
 * @author: zhuge
 * @date: 2018/12/31 15:22
 */

@RestController
@RequestMapping(path = "/goodsController")
@Api(description = "goodsController description")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @ApiOperation(value = "添加一个商品", notes = "添加一个商品")
    @RequestMapping(path = "/add", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String add(@RequestBody Goods goods) {
        try {
            goodsService.insert(goods);
            return "Success!";
        } catch (Exception e) {
            e.printStackTrace();
            return "failed!";
        }
    }

    @ApiOperation(value = "查询一个商品", notes = "查询一个商品")
    @RequestMapping(path = "/query", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Goods query(@RequestParam("id") Integer id) {
        try {
            return goodsService.query(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
