package iPet.service;

import iPet.model.User;
import iPet.pager.IQuery;
import iPet.pager.PageResult;

public interface IUserService {

	void save(User user);

	void update(User user);

	void delete(java.io.Serializable id);

	void destroy(java.io.Serializable id);

	User get(java.io.Serializable id);

	User findUserByName(String name);

	PageResult<User> findPageResult(IQuery query);

	boolean findUserByEmail(String email);

	void regist(String email, String password);

}
