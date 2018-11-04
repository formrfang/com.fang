package com.fang.demo.dao;

import com.fang.demo.config.tkmapper.MyMapper;
import com.fang.demo.pojo.ipaddr;

public interface ipaddrMapper extends MyMapper<ipaddr> {
    //查询次数
    Integer findCount();

}
