package com.zhuge.springbootlearn.formprocess.controller;

import com.zhuge.springbootlearn.formprocess.domain.Goods;
import com.zhuge.springbootlearn.formprocess.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Title: OrderController
 * @Description:
 * @author: zhuge
 * @date: 2019/1/1 19:06
 */
@Controller
@RequestMapping(path = "/goods",
        consumes = {MediaType.ALL_VALUE},
        produces = {MediaType.ALL_VALUE})
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping(path = "/showAll")
    public String showAll(Model model) {
        List<Goods> allGoods = Collections.emptyList();
        try {
            allGoods = goodsService.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("goodsList", allGoods);
        return "showAll.html";
    }

    @PostMapping(path = "/add", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String add(@Valid Goods goods, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return "redirect:/goods/addPage";
        } else {
            goodsService.add(goods);
            return "redirect:/goods/showAll";
        }
    }

    @GetMapping(path = "/addPage")
    public String addPage() {
        return "addPage.html";
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity exceptionHandler(Exception e) {
        return ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .build();
    }
}
