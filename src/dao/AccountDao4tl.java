package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.DataSourceUtils;
import utils.JdbcUtils;

public class AccountDao4tl {

	public void accountout(String fromuser, String money) throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = DataSourceUtils.getConnection();
			//��дsql
			String sql = "update account set money = money-? where name = ?";
			//�������ִ����
			st =conn.prepareStatement(sql);
			//���ò���
			st.setString(1, money);
			st.setString(2, fromuser);
			//ִ��SQL
			int i=st.executeUpdate();
			//����
			System.out.println("����"+i);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DataSourceUtils.closeResourse(st, rs);
		}
	}
	public void accountin(String toUser, String money) throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = DataSourceUtils.getConnection();
			//��дsql
			String sql = "update account set money = money+? where name = ?";
			//�������ִ����
			st =conn.prepareStatement(sql);
			//���ò���
			st.setString(1, money);
			st.setString(2, toUser);
			//ִ��SQL
			int i=st.executeUpdate();
			//����
			System.out.println("�룺"+i);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DataSourceUtils.closeResourse(st, rs);
		}
	}
}
