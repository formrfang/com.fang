package com.fang.demo.controller;

import com.alibaba.fastjson.JSON;
import com.fang.demo.config.service.RedisService;
import com.fang.demo.pojo.helloworld;
import com.fang.demo.pojo.ipaddr;
import com.fang.demo.service.impl.ServiceImpl;
import com.fang.demo.util.IPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class user {
    @Autowired
    private ServiceImpl service;
    @Autowired
    RedisService redisService;

   /* @ResponseBody
    @RequestMapping("/index1")
    public String test(Model model) {
        List<helloworld> list = service.testselect();
        return list.get(new Random().nextInt(list.size())).getName();
    }

    @RequestMapping("/index")
    public String test1(Model model) {
        model.addAttribute("name", redisService.get("1"));
        return "index";
    }*/
    @RequestMapping("/")
    public String test2(HttpServletRequest request, Model model) {
        String ip = IPUtils.getIpAddr(request);
        ipaddr ipaddr = service.findIpaddrByIp(ip);
        model.addAttribute("ip",ipaddr);
        model.addAttribute("num",service.findCount());
        return "index";
    }


}
