package iPet.service.impl;

import iPet.dao.BaseDao;
import iPet.model.User;
import iPet.pager.IQuery;
import iPet.pager.PageResult;
import iPet.service.IUserService;
import iPet.util.LogicException;

import java.io.Serializable;

/**
 * @Description: 操作用户
 * @author rongfa
 * @date 2015-3-24 下午9:22:55
 */
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
			user.setPassword(user.getPassword());
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
	public User findUserByEmail(String email) {
		Object user = dao.findObjectByHql("FROM User u WHERE u.email = ?", email);
		return (User) (user == null ? null : user);
	}
}
