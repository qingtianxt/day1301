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
			//编写sql
			String sql = "update account set money = money-? where name = ?";
			//创建语句执行者
			st =conn.prepareStatement(sql);
			//设置参数
			st.setString(1, money);
			st.setString(2, fromuser);
			//执行SQL
			int i=st.executeUpdate();
			//处理
			System.out.println("出："+i);
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
			//编写sql
			String sql = "update account set money = money+? where name = ?";
			//创建语句执行者
			st =conn.prepareStatement(sql);
			//设置参数
			st.setString(1, money);
			st.setString(2, toUser);
			//执行SQL
			int i=st.executeUpdate();
			//处理
			System.out.println("入："+i);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DataSourceUtils.closeResourse(st, rs);
		}
	}
}
