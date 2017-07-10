package service;

import dao.AccountDao4DB;
import utils.DataSourceUtils;

public class AccountService4DB {

	/**
	 * ת��
	 * @param fromuser ת����
	 * @param touser ת�뷽
	 * @param money ���
	 * @throws Exception 
	 */
	public void account(String fromuser, String touser, String money) throws Exception {
		AccountDao4DB dao = new AccountDao4DB();
		try {
			DataSourceUtils.startTransaction();
			//1.ת��
			dao.accountout(fromuser,money);
//			int i=1/0;
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
