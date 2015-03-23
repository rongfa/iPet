package iPet.service.impl;

import iPet.dao.BaseDao;
import iPet.model.User;
import iPet.pager.IQuery;
import iPet.pager.PageResult;
import iPet.service.IUserService;
import iPet.util.LogicException;
import iPet.util.MD5;

import java.io.Serializable;

public class UserServiceImpl implements IUserService {

	private BaseDao<User> dao;
	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setDao(BaseDao<User> dao) {
		this.dao = dao;
	}

	@Override
	public void save(User user) {
		// 判断用户名是否存在
		User u = findUserByName(user.getName());
		if (u == null) {
			// 获取MD5密码
			String md5Pwd = MD5.encode(user.getPassword());
			user.setPassword(md5Pwd);
			dao.save(user);
		} else {
			throw new LogicException("用户名已经存在了.");
		}
	}

	@Override
	public void update(User user) {
		dao.update(user);
	}

	@Override
	public void delete(Serializable id) {
		User user = get(id);
		update(user);
	}

	@Override
	public User get(Serializable id) {
		return dao.get(id);
	}

	@Override
	public User findUserByName(String name) {
		Object user = dao.findObjectByHql("FROM User u WHERE u.name = ?", name);
		return user == null ? null : (User) user;
	}

	@Override
	public PageResult<User> findPageResult(IQuery query) {
		return dao.findPageResult(query);
	}

	@Override
	public void destroy(Serializable id) {
		dao.delete(id);
	}

	@Override
	public boolean findUserByEmail(String email) {
		Object user = dao.findObjectByHql("FROM User u WHERE u.email = ?",
				email);
		return user != null;
	}

	@Override
	public void regist(String email, String password) {
		User newUser = new User();
		newUser.setEmail(email);
		newUser.setName(email.substring(0, email.indexOf('@')));
		newUser.setSex(0);
		newUser.setPassword(MD5.encode(password));
		dao.save(newUser);
	}
}
