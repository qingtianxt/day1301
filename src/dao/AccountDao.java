package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.JdbcUtils;

public class AccountDao {
/**
 * ת��Ǯ
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
			//��дsql
			String sql = "update account set money = money-? where name=?";
			
			//�������ִ����
			st = conn.prepareStatement(sql);
			
			//���ò���
			st.setString(1, money);
			st.setString(2, fromuser);
			//ִ��sql 
			int i = st.executeUpdate();
			//����
			System.out.println("����"+i);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			JdbcUtils.closeResouse(conn, st, rs);
		}
		
	}
/**
 * ת��
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
			//��дsql
			String sql = "update account set money = money+? where name=?";
			
			//�������ִ����
			st = conn.prepareStatement(sql);
			
			//���ò���
			st.setString(1, money);
			st.setString(2, touser);
			//ִ��sql 
			int i = st.executeUpdate();
			//����
			System.out.println("�룺"+i);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw e;
		}finally{
			JdbcUtils.closeResouse(conn, st, rs);
		}
	}

	
	/**
	 * ת��Ǯ
	 * @param fromuser
	 * @param money
	 * @throws Exception 
	 */
		public void accountout(Connection conn,String fromuser, String money) throws Exception {
			PreparedStatement st = null;
			ResultSet rs= null;
			try {
				//��дsql
				String sql = "update account set money = money-? where name=?";
				
				//�������ִ����
				st = conn.prepareStatement(sql);
				
				//���ò���
				st.setString(1, money);
				st.setString(2, fromuser);
				//ִ��sql 
				int i = st.executeUpdate();
				//����
				System.out.println("����"+i);
				
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}finally{
//				JdbcUtils.closeResouse(conn, st, rs);
				JdbcUtils.closeResultSet(rs);
			}
			
		}
	/**
	 * ת��
	 * @param touser
	 * @param money
	 * @throws Exception 
	 */
		public void accountin(Connection conn,String touser, String money) throws Exception {
			PreparedStatement st = null;
			ResultSet rs= null;
			try {
				//��дsql
				String sql = "update account set money = money+? where name=?";
				
				//�������ִ����
				st = conn.prepareStatement(sql);
				
				//���ò���
				st.setString(1, money);
				st.setString(2, touser);
				//ִ��sql 
				int i = st.executeUpdate();
				//����
				System.out.println("�룺"+i);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				throw e;
			}finally{
				//JdbcUtils.closeResouse(conn, st, rs);
				JdbcUtils.closeResultSet(rs);
			}
		}

}
