package com.zzp.pratise.Useful;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by zhuzhengping
 * on 2017/9/7.
 */
public class OracleJdbcTest {

    //        5. 使用JDBC链接Oracle

        String driverClass = "oracle.jdbc.driver.OracleDriver";

        Connection con;

        public void init(FileInputStream fs) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException
        {
            Properties props = new Properties();
            props.load(fs);
            String url = props.getProperty("db.url");
            String userName = props.getProperty("db.user");
            String password = props.getProperty("db.password");
            Class.forName(driverClass);

            con= DriverManager.getConnection(url, userName, password);
        }

        public void fetch() throws SQLException, IOException {
            PreparedStatement ps = con.prepareStatement("select SYSDATE from dual");
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                // do the thing you do
            }
            rs.close();
            ps.close();
        }

        public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
            OracleJdbcTest test = new OracleJdbcTest();
            test.init(new FileInputStream(""));
            test.fetch();
        }
}
