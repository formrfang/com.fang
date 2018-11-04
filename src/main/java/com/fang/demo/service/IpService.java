package com.fang.demo.service;

import com.fang.demo.config.service.IService;
import com.fang.demo.pojo.helloworld;
import com.fang.demo.pojo.ipaddr;

import java.util.List;

public interface IpService extends IService<ipaddr> {
    int testInsert();
    List<helloworld> testselect();
    //查询IP
    ipaddr findIpaddrByIp(String ip);
    //查询次数
    Integer findCount();
}
