package Util;

import javax.sql.DataSource;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.apache.commons.dbcp.BasicDataSource;

public class DbSoureUtil {
	public static DataSource ds =null;
	public static DataSource getDataSource() {
		
        if (ds == null) {
            synchronized (DataSource.class) {
                if (ds == null) {
                    ds = getNewDataSource();
                }
            }
        }
        return ds;
	}
	private static DataSource getNewDataSource() {
		BasicDataSource bds =new BasicDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/HRDB?userUnicode=true&characterEncoding=utf8&serverTimezone=UTC");
		bds.setUsername("root");
		bds.setPassword("105402@xge");
		bds.setInitialSize(5);
		bds.setMaxActive(10);
		bds.setMaxIdle(10);
		return bds;
	}
}
