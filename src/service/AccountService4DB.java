package service;

import dao.AccountDao4DB;
import utils.DataSourceUtils;

public class AccountService4DB {

	/**
	 * 转账
	 * @param fromuser 转出方
	 * @param touser 转入方
	 * @param money 金额
	 * @throws Exception 
	 */
	public void account(String fromuser, String touser, String money) throws Exception {
		AccountDao4DB dao = new AccountDao4DB();
		try {
			DataSourceUtils.startTransaction();
			//1.转出
			dao.accountout(fromuser,money);
//			int i=1/0;
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
