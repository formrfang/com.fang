package com.fang.demo.service;

import com.fang.demo.test.JDBCUtils;
import org.junit.Test;

import java.sql.*;

public class jdbcutil {
    /*public void test() throws SQLException {
        String driver = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@182.92.105.58:1521:byqhorcl";
        String user = "lh";
        String password = "pro_lhyt";
        String sql="insert into SYS_MANAGER_ROLE (ROLE_ID,ROLE_NAME) VALUES(2,'测试')";
    //conn(driver,url,user,password,sql);
        JDBCUtils jdbcUtils = new JDBCUtils(url,user,password);
        Connection conn = jdbcUtils.getConnection();
        conn.setAutoCommit(false);
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.executeUpdate();
        //int i=1/0;
       // conn.commit();

    }

    public void conn(String driver,String url,String user,String password,String sql) throws SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        boolean flag = false;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            //开启事务
            con.setAutoCommit(false);
            pstm = con.prepareStatement(sql);
            int i = pstm.executeUpdate();
            System.out.println(i);
            Thread.sleep(10000);
            con.rollback();


            //con.commit();
            flag = true;
        } catch (Exception e) {
            try {
                //异常回滚事务
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {

            // 关闭执行通道
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // 关闭连接通道
            try {
                if (con != null && (!con.isClosed())) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (flag) {
            System.out.println("执行成功！");
        } else {
            System.out.println("执行失败！");
        }
    }*/
}
