package Util;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class DbSoureUtil {
	public static DataSource ds =null;
	static {
		BasicDataSource bds =new BasicDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/HRDB?userUnicode=true&characterEncoding=utf8&serverTimezone=UTC");
		bds.setUsername("root");
		bds.setPassword("105402@xge");
		bds.setInitialSize(5);
		bds.setMaxActive(10);
		bds.setMaxIdle(10);
		ds = bds;
	}
}
