package com.fang.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.fang.demo.config.service.RedisService;
import com.fang.demo.config.service.impl.BaseService;
import com.fang.demo.dao.ipaddrMapper;
import com.fang.demo.dao.testDao;
import com.fang.demo.pojo.helloworld;
import com.fang.demo.pojo.ipaddr;
import com.fang.demo.service.IpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class ServiceImpl extends BaseService<ipaddr> implements IpService {

    @Autowired
    private testDao testDao;
    @Autowired
    private RedisService redisService;

    public int testInsert() {
        HashMap<String, String> hashMap = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        sb.append("id,").append("name");
        hashMap.put("sql", sb.toString());
        hashMap.put("value", "1,'方'");
        return testDao.testInsert(hashMap);
    }

    @Override
    public List<helloworld> testselect() {
        return testDao.testselect();
    }

    @Autowired
    private ipaddrMapper ipaddrMapper;

    @Override
    public ipaddr findIpaddrByIp(String ip) {
        if (!redisService.exists("ip:" + ip)) {
            //redis中不存在该IP缓存
            //通用mapper根据ip查询
            Example example = new Example(ipaddr.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("ip", ip);
            List<ipaddr> ipaddrs = ipaddrMapper.selectByExample(example);
            //redis中不存在,且是第一次进入网站
            if (null == ipaddrs || ipaddrs.size() < 1) {
                ipaddr ipaddr = new ipaddr();
                ipaddr.setIp(ip);
                ipaddr.setCount(1);
                ipaddr.setTime(new Date());
                ipaddrMapper.insert(ipaddr);
                redisService.set("ip:" + ip, JSON.toJSONString(ipaddr));
                redisService.pexpire("ip:" + ip, 180000L);//3分钟
                return ipaddr;
            } else {
                //redis中不存在,但非第一次
                ipaddr ipaddr = ipaddrs.get(0);
                ipaddr.setCount(ipaddr.getCount() + 1);
                ipaddr result = new ipaddr();
                result.setTime(ipaddr.getTime());
                result.setCount(ipaddr.getCount());
                result.setIp(ipaddr.getIp());
                result.setId(ipaddr.getId());
                ipaddr.setTime(new Date());
                ipaddrMapper.updateByPrimaryKeySelective(ipaddr);
                redisService.set("ip:" + ip, JSON.toJSONString(ipaddr));
                redisService.pexpire("ip:" + ip, 180000L);//3分钟
                return result;
            }
        } else {
            //redis中存在
            String s = redisService.get("ip:" + ip);
            ipaddr ipaddr = JSON.parseObject(s, ipaddr.class);
            return ipaddr;
        }
    }

    @Override
    public Integer findCount() {
        if(redisService.exists("num")){
            return Integer.valueOf(redisService.get("num"));
        }else {
            Integer count = ipaddrMapper.findCount();
            redisService.set("num",count.toString());
            redisService.pexpire("num",60000L);//1分钟
            return count;
        }
    }
}
