package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.JdbcUtils;

public class AccountDao {
/**
 * 转出钱
 * @param fromuser
 * @param money
 * @throws Exception 
 */
	public void accountout_(String fromuser, String money) throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs= null;
		try {
			conn  = JdbcUtils.getConnection();
			//编写sql
			String sql = "update account set money = money-? where name=?";
			
			//创建语句执行者
			st = conn.prepareStatement(sql);
			
			//设置参数
			st.setString(1, money);
			st.setString(2, fromuser);
			//执行sql 
			int i = st.executeUpdate();
			//处理
			System.out.println("出："+i);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			JdbcUtils.closeResouse(conn, st, rs);
		}
		
	}
/**
 * 转入
 * @param touser
 * @param money
 * @throws Exception 
 */
	public void accountin_(String touser, String money) throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs= null;
		try {
			conn  = JdbcUtils.getConnection();
			//编写sql
			String sql = "update account set money = money+? where name=?";
			
			//创建语句执行者
			st = conn.prepareStatement(sql);
			
			//设置参数
			st.setString(1, money);
			st.setString(2, touser);
			//执行sql 
			int i = st.executeUpdate();
			//处理
			System.out.println("入："+i);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw e;
		}finally{
			JdbcUtils.closeResouse(conn, st, rs);
		}
	}

	
	/**
	 * 转出钱
	 * @param fromuser
	 * @param money
	 * @throws Exception 
	 */
		public void accountout(Connection conn,String fromuser, String money) throws Exception {
			PreparedStatement st = null;
			ResultSet rs= null;
			try {
				//编写sql
				String sql = "update account set money = money-? where name=?";
				
				//创建语句执行者
				st = conn.prepareStatement(sql);
				
				//设置参数
				st.setString(1, money);
				st.setString(2, fromuser);
				//执行sql 
				int i = st.executeUpdate();
				//处理
				System.out.println("出："+i);
				
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}finally{
//				JdbcUtils.closeResouse(conn, st, rs);
				JdbcUtils.closeResultSet(rs);
			}
			
		}
	/**
	 * 转入
	 * @param touser
	 * @param money
	 * @throws Exception 
	 */
		public void accountin(Connection conn,String touser, String money) throws Exception {
			PreparedStatement st = null;
			ResultSet rs= null;
			try {
				//编写sql
				String sql = "update account set money = money+? where name=?";
				
				//创建语句执行者
				st = conn.prepareStatement(sql);
				
				//设置参数
				st.setString(1, money);
				st.setString(2, touser);
				//执行sql 
				int i = st.executeUpdate();
				//处理
				System.out.println("入："+i);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				throw e;
			}finally{
				//JdbcUtils.closeResouse(conn, st, rs);
				JdbcUtils.closeResultSet(rs);
			}
		}

}
