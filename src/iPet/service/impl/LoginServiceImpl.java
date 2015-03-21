package iPet.service.impl;

import iPet.dao.BaseDao;
import iPet.model.User;
import iPet.service.ILoginService;

public class LoginServiceImpl implements ILoginService {

	private BaseDao<User> dao;

	public void setDao(BaseDao<User> dao) {
		this.dao = dao;
	}

	@Override
	public User login(String name, String password) {

		// String md5Pwd = MD5.encode(password);
		Object user = dao.findObjectByHql( "FROM User u WHERE u.name = ? AND u.password = ?", name, password);
		if (user == null) {
			user = dao.findObjectByHql( "FROM User u WHERE u.phoneNum = ? AND u.password = ?", name, password);
		}
		return user == null ? null : (User) user;
	}
}
