package iPet.service.impl;

import iPet.dao.BaseDao;
import iPet.model.User;
import iPet.service.ILoginService;
import iPet.util.MD5;

/**
 * @Description:登入
 * @author rongfa
 * @date 2015-3-24 下午9:22:24
 */
public class LoginServiceImpl implements ILoginService {

	private BaseDao<User> dao;

	public void setDao(BaseDao<User> dao) {
		this.dao = dao;
	}

	@Override
	public User login(String name, String password) {
		Object user = dao.findObjectByHql("FROM User u WHERE u.email = ? OR u.name = ? ", name, name);
		if (user != null) {
			String dbPassword = ((User) user).getPassword();
			String md5Pwd = MD5.encode(password);
			if (dbPassword.equals(md5Pwd)) {
				return (User) user;
			}
		}
		return null;
	}
}
