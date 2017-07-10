package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbutils.QueryRunner;

import utils.DataSourceUtils;
import utils.JdbcUtils;

public class AccountDao4DB {

	public void accountout(String fromuser, String money) throws Exception {
		//¥¥Ω®queryRunner
		QueryRunner qr = new QueryRunner();
		
		//±‡–¥sql
		String sql  = "update account set money = money - ? where name = ?";
		
		//÷¥––sql
		
		qr.update(DataSourceUtils.getConnection(),sql,money,fromuser);
		
	}
	public void accountin(String toUser, String money) throws Exception {
	QueryRunner qr = new QueryRunner();
	
	String sql = "update account set money = money + ? where name = ?";
	
	qr.update(DataSourceUtils.getConnection(),sql,money,toUser);
	}
}
