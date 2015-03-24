package iPet.service;

import iPet.model.User;
import iPet.pager.IQuery;
import iPet.pager.PageResult;

/**
 * @Description: 用户service层
 * @author rongfa
 * @date 2015-3-24 下午9:21:30
 */
public interface IUserService {

	/**
	 * @Description:保存
	 * @param user
	 *            需要保存的对象
	 */
	void save(User user);

	/**
	 * @Description: 更新
	 * @param user
	 *            需要更新的对象
	 */
	void update(User user);

	/**
	 * @Description: 根据id删除对象-->改变状态 假删除
	 * @param id
	 *            用户id
	 */
	void delete(java.io.Serializable id);

	/**
	 * @Description:销毁对象
	 * @param id
	 *            用户id
	 */
	void destroy(java.io.Serializable id);

	/**
	 * @Description: 根据id获取对象
	 * @param id
	 *            对象id
	 * @return 对象
	 */
	User get(java.io.Serializable id);

	/**
	 * @Description: 通过用户名获取对象
	 * @param name
	 *            用户名
	 * @return 对象
	 */
	User findUserByName(String name);

	/**
	 * @Description: 分页获取对象
	 * @param query
	 *            查询条件
	 * @return 查询结果
	 */
	PageResult<User> findPageResult(IQuery query);

	/**
	 * @Description: 通过email获取对象
	 * @param email
	 *            用户email
	 * @return 对象F
	 */
	User findUserByEmail(String email);
}
