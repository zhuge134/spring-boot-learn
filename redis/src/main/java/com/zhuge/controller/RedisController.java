package com.zhuge.controller;

import com.zhuge.dao.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/redisController",
        consumes = {
                MediaType.ALL_VALUE,
                MediaType.TEXT_PLAIN_VALUE,
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE},
        produces = {
                /*MediaType.ALL_VALUE,*/
                MediaType.TEXT_PLAIN_VALUE,
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE
        })
public class RedisController {

    @Autowired
    private RedisDao redisDao;

    @RequestMapping(path = "/publish", method = RequestMethod.POST)
    public String publish(@RequestParam("channel") String channel,
                          @RequestParam("msg") String msg) {
        try {
            redisDao.publish(channel, msg);
            return "success!";
        } catch (Exception e) {
            return "failed!";
        }
    }

    @RequestMapping(path = "/setValue", method = RequestMethod.POST)
    public String setValue(@RequestParam("key") String key,
                           @RequestParam("value") String value) {
        try {
            redisDao.setKey(key, value);
            return "success!";
        } catch (Exception e) {
            e.printStackTrace();
            return "failed!";
        }
    }

    @RequestMapping(path = "/getValue/{key}", method = RequestMethod.GET)
    public String getValue(@PathVariable("key") String key) {
        try {
            String value = redisDao.getValue(key);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return "failed!";
        }
    }
}
