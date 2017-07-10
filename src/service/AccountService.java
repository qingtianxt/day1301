package service;

import java.sql.Connection;

import dao.AccountDao;
import utils.JdbcUtils;

public class AccountService {

	/**
	 * 转账
	 * @param fromuser 转出方
	 * @param touser 转入方
	 * @param money 金额
	 * @throws Exception 
	 */
	public void account(String fromuser, String touser, String money) throws Exception {
		AccountDao dao = new AccountDao();
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false);
			//1.转出
			dao.accountout(conn,fromuser,money);
			int i=1/0;
			//2.转入
			dao.accountin(conn,touser,money);
			//3.事务提交
			conn.commit();
			JdbcUtils.closeConn(conn);
		} catch (Exception e) {
			e.printStackTrace();
			//事务回滚
			conn.rollback();
			JdbcUtils.closeConn(conn);
			throw e;
		}
	
		
	}

}
