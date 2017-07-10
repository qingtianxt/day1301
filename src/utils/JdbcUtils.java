package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

//文档注释好处：可以在调用的方法出现时所做的注释

public class JdbcUtils {
	//ctrl+shift+x小写变大写
	//向下复制一行alt+ctrl——下键
	//向上复制一行alt+ctrl——上键
	//向下添加一个空行shift+enter
	//向上添加一个空行ctrl+shift+enter
	//删除一行 选中行 ctrl+d
	//向下或者向上一动一行 alt+上下键
	//ctrl+shift+y大写
	//获取ResourceBundle Ctrl+2 l
	static final String DRIVERCLASS;//块编辑：alt+shift+a
	static final String URL;
	static final String USER;
	static final String PASSWORD;
	static {
				ResourceBundle bundle =ResourceBundle.getBundle("jdbc");
				//获取制定的内容
				 DRIVERCLASS=bundle.getString("driverClass");
				 URL=bundle.getString("url");
				 USER=bundle.getString("user");
				 PASSWORD=bundle.getString("password");
	}
	static {

		//注册驱动
		try {
			Class.forName(DRIVERCLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//获取连接
	public static Connection getConnection() throws Exception{
	
	
		//获取连接 整理包
		return  DriverManager.getConnection(URL, USER, PASSWORD);
		
	}
	//释放资源
	public static void closeResouse(Connection conn,Statement st,ResultSet rs)
	{
		closeResultSet(rs);
		closeStatement(st);
		closeConn(conn);
	}
	/**
	 * 释放链接
	 * @param conn 连接
	 * */
	public static void closeConn(Connection conn)
	{
		if(conn!=null)
		{
			try{
				conn.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			conn=null;
		}
	}
	/**
	 * 释放链接
	 * @param st 连接
	 * */
	public static void closeStatement(Statement st)
	{
		if(st!=null)
		{
			try{
				st.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			st=null;
		}
	}
	/**
	 * 释放链接
	 * param rs结果集 连接
	 * */
	public static void closeResultSet(ResultSet rs)
	{
		if(rs!=null)
		{
			try{
				rs.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			rs=null;
		}
	}
}
