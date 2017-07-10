package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

//�ĵ�ע�ͺô��������ڵ��õķ�������ʱ������ע��

public class JdbcUtils {
	//ctrl+shift+xСд���д
	//���¸���һ��alt+ctrl�����¼�
	//���ϸ���һ��alt+ctrl�����ϼ�
	//�������һ������shift+enter
	//�������һ������ctrl+shift+enter
	//ɾ��һ�� ѡ���� ctrl+d
	//���»�������һ��һ�� alt+���¼�
	//ctrl+shift+y��д
	//��ȡResourceBundle Ctrl+2 l
	static final String DRIVERCLASS;//��༭��alt+shift+a
	static final String URL;
	static final String USER;
	static final String PASSWORD;
	static {
				ResourceBundle bundle =ResourceBundle.getBundle("jdbc");
				//��ȡ�ƶ�������
				 DRIVERCLASS=bundle.getString("driverClass");
				 URL=bundle.getString("url");
				 USER=bundle.getString("user");
				 PASSWORD=bundle.getString("password");
	}
	static {

		//ע������
		try {
			Class.forName(DRIVERCLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//��ȡ����
	public static Connection getConnection() throws Exception{
	
	
		//��ȡ���� �����
		return  DriverManager.getConnection(URL, USER, PASSWORD);
		
	}
	//�ͷ���Դ
	public static void closeResouse(Connection conn,Statement st,ResultSet rs)
	{
		closeResultSet(rs);
		closeStatement(st);
		closeConn(conn);
	}
	/**
	 * �ͷ�����
	 * @param conn ����
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
	 * �ͷ�����
	 * @param st ����
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
	 * �ͷ�����
	 * param rs����� ����
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
