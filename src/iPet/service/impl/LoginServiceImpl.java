package iPet.service.impl;

import iPet.dao.BaseDao;
import iPet.model.User;
import iPet.service.ILoginService;
import iPet.util.MD5;

public class LoginServiceImpl implements ILoginService {

	private BaseDao<User> dao;

	public void setDao(BaseDao<User> dao) {
		this.dao = dao;
	}

	@Override
	public User login(String name, String password) {
		String md5Pwd = MD5.encode(password);
		Object user = dao .findObjectByHql( "FROM User u WHERE u.name = ? AND u.password = ?", name, md5Pwd);
		if (user == null) {
			user = dao.findObjectByHql( "FROM User u WHERE u.email = ? AND u.password = ?", name, md5Pwd);
		}
		return user == null ? null : (User) user;
	}
}
