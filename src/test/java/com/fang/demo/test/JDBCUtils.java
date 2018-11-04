package com.fang.demo.test;

import com.fang.demo.controller.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
   /* private static String driver = "oracle.jdbc.OracleDriver";
    private String url;
    private String user;
    private String password;

    public JDBCUtils(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }


    static {
        *//**
         * 驱动注册
         *//*
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }

    }

    *//**
     * 获取 Connetion
     *
     * @return
     * @throws SQLException
     *//*
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    *//**
     * 释放资源
     *
     * @param conn
     * @param st
     * @param rs
     *//*
    public static void colseResource(Connection conn, Statement st, ResultSet rs) {
        closeResultSet(rs);
        closeStatement(st);
        closeConnection(conn);
    }

    *//**
     * 释放连接 Connection
     *
     * @param conn
     *//*
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //等待垃圾回收
        conn = null;
    }

    *//**
     * 释放语句执行者 Statement
     *
     * @param st
     *//*
    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //等待垃圾回收
        st = null;
    }

    *//**
     * 释放结果集 ResultSet
     *
     * @param rs
     *//*
    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //等待垃圾回收
        rs = null;
    }*/
}