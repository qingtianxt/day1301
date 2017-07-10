package service;

import java.sql.Connection;

import com.mysql.fabric.xmlrpc.base.Data;

import dao.AccountDao;
import dao.AccountDao4tl;
import utils.DataSourceUtils;
import utils.JdbcUtils;

public class AccountService4tl {

	/**
	 * 转账
	 * @param fromuser 转出方
	 * @param touser 转入方
	 * @param money 金额
	 * @throws Exception 
	 */
	public void account(String fromuser, String touser, String money) throws Exception {
		AccountDao4tl dao = new AccountDao4tl();
		try {
			DataSourceUtils.startTransaction();
			//1.转出
			dao.accountout(fromuser,money);
			int i=1/0;
			//2.转入
			dao.accountin(touser,money);
			//3.事务提交
			DataSourceUtils.commitAndClose();
		} catch (Exception e) {
			e.printStackTrace();
			//事务回滚
		DataSourceUtils.rollbackAndClose();
			throw e;
		}
	
		
	}

}
