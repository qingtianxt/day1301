package service;

import java.sql.Connection;

import com.mysql.fabric.xmlrpc.base.Data;

import dao.AccountDao;
import dao.AccountDao4tl;
import utils.DataSourceUtils;
import utils.JdbcUtils;

public class AccountService4tl {

	/**
	 * ת��
	 * @param fromuser ת����
	 * @param touser ת�뷽
	 * @param money ���
	 * @throws Exception 
	 */
	public void account(String fromuser, String touser, String money) throws Exception {
		AccountDao4tl dao = new AccountDao4tl();
		try {
			DataSourceUtils.startTransaction();
			//1.ת��
			dao.accountout(fromuser,money);
			int i=1/0;
			//2.ת��
			dao.accountin(touser,money);
			//3.�����ύ
			DataSourceUtils.commitAndClose();
		} catch (Exception e) {
			e.printStackTrace();
			//����ع�
		DataSourceUtils.rollbackAndClose();
			throw e;
		}
	
		
	}

}
