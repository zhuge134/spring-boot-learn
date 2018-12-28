package com.zhuge.controller;

import com.zhuge.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/myController",
        produces = {
                MediaType.TEXT_PLAIN_VALUE,
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE},
        consumes = {
                MediaType.TEXT_PLAIN_VALUE,
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE})
public class MyController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(path = "/transfer", method = RequestMethod.GET)
    public String transfer(@RequestParam("user1") int user1,
                           @RequestParam("user2") int user2,
                           @RequestParam("money") int money) {
        try {
            accountService.transfer(user1, user2, money, false);
            return "Success!";
        } catch (Exception e) {
            return "failed!";
        }
    }

}
