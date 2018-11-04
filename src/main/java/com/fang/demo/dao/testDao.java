package com.fang.demo.dao;

import com.fang.demo.pojo.helloworld;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface testDao {
    int testInsert(HashMap<String,String> map);
    List<helloworld> testselect();
}
