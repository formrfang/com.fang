package com.fang.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "ipaddr")
public class ipaddr {
    @Override
    public String toString() {
        return "ipaddr{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", count=" + count +
                ", time=" + time +
                '}';
    }

    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    private Integer id;
    @Column(name = "ip")
    private String ip;
    @Column(name = "count")
    private Integer count;
    @Column(name = "time")
    @DateTimeFormat
    @JsonFormat
    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
