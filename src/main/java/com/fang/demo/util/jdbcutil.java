package com.fang.demo.util;

import java.sql.*;

public class jdbcutil {
/*
    public  void conn(){
        String driver = "oracle.jdbc.OracleDriver";    //驱动标识符
        String url = "jdbc:oracle:thin:@182.92.105.58:1521:byqhorcl"; //链接字符串
        // url ="jdbc:oracle:thin:@10.0.30.64:1521:orcl";  // 连接远程的数据库可以这么写
        String user = "lh";         //数据库的用户名
        String password = "pro_lhyt";     //数据库的密码
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        boolean flag = false;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,user, password);
            String sql = "select * from LIAOHE_USER_MENU";
            pstm =con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()) {
                String ename =rs.getString("FUN_NAME");
                System.out.println(ename);
            }

            flag = true;
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // 关闭执行通道
            if(pstm !=null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // 关闭连接通道
            try {
                if(con != null &&(!con.isClosed())) {
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

        if(flag) {
            System.out.println("执行成功！");
        } else {
            System.out.println("执行失败！");
        }
    }*/
}
