package util;

import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils {
  private static BasicDataSource dataSource;
  static {
	  Properties prop = new Properties();
	  InputStream ips = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
	  try {
		  prop.load(ips);
		  //获取属性配置文件的数据
		  String driver = prop.getProperty("driver");
		  String url = prop.getProperty("url");
		  String username = prop.getProperty("username");
		  String password = prop.getProperty("password");
		  int min = Integer.parseInt(prop.getProperty("min"));
		  int max = Integer.parseInt(prop.getProperty("max"));
		  
		  dataSource = new BasicDataSource();
		  //设置数据连接的参数
		  dataSource.setDriverClassName(driver);
		  dataSource.setUrl(url);
		  dataSource.setUsername(username);
		  dataSource.setPassword(password);
		  //设置初始连接数量和最大连接数量
		  dataSource.setInitialSize(min);
		  dataSource.setMaxActive(max);
	  }catch(IOException e) {
		  e.printStackTrace();
	  }
  }
  
  public static Connection getConn() throws Exception{
	  return dataSource.getConnection();
  }
  public static void close(Connection conn,Statement stat,ResultSet rs) {
	  try {
		  if(rs!=null)rs.close();
	  }catch(SQLException e) {
		  e.printStackTrace();
	  }
	  try {
		  if(stat!=null)stat.close();
	  }catch(SQLException e) {
		  e.printStackTrace();
	  }
	  try {
		  if(conn!=null)conn.close();
	  }catch(SQLException e) {
		  e.printStackTrace();
	  }
  }
}












