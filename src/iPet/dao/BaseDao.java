package iPet.dao;

import iPet.pager.IQuery;
import iPet.pager.PageResult;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

@SuppressWarnings("all")
public class BaseDao<T> extends HibernateDaoSupport {

	private Class<T> entityClass;

	public BaseDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	public void delete(Serializable id) {
		getHibernateTemplate().delete(get(id));
	}

	public T get(Serializable id) {
		T t = getHibernateTemplate().get(entityClass, id);
		if (t == null) {
			throw new RuntimeException("找不到对应id=" + id + "的对象");
		}
		return t;
	}

	public List<T> getAll(Class<T> entityClass) {
		return getHibernateTemplate().loadAll(entityClass);
	}

	public PageResult<T> findPageResult(final IQuery baseQuery) {
		int count = findCount(entityClass, baseQuery);
		if (count == 0) {
			return new PageResult<T>();
		}

		final PageResult<T> pageResult = new PageResult<T>(
				baseQuery.getCurrentPage(), baseQuery.getPageSize(), count);
		// select o from Employee o where o.username like ? and o.email like ?
		final StringBuilder builder = new StringBuilder("select o from "
				+ entityClass.getName() + " o");
		String where = baseQuery.getWhere();
		// 有查询条件
		if (StringUtils.isNotBlank(where)) {
			builder.append(" where ").append(where);
		}
		System.out.println("PageResult findPageResult:" + builder.toString());

		List<T> rows = getHibernateTemplate().execute(
				new HibernateCallback<List<T>>() {
					public List<T> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(builder.toString());
						// 设置查询条件的值
						List params = baseQuery.getParams();
						int index = 0;
						for (Object object : params) {
							query.setParameter(index++, object);
						}
						// 设置分页的信息
						int first = (pageResult.getCurrentPage() - 1)
								* pageResult.getPageSize();
						int max = pageResult.getPageSize();
						query.setFirstResult(first).setMaxResults(max);
						return query.list();
					}
				});
		pageResult.setRows(rows);
		return pageResult;
	}

	private int findCount(Class<T> entityClass, final IQuery baseQuery) {
		final StringBuilder builder = new StringBuilder("select count(o) from "
				+ entityClass.getName() + " o");
		String where = baseQuery.getWhere();
		// 有查询条件
		if (StringUtils.isNotBlank(where)) {
			builder.append(" where ").append(where);
		}
		System.out.println("PageResult findCount:" + builder.toString());

		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(builder.toString());
				// 设置查询条件的值
				List params = baseQuery.getParams();
				int index = 0;
				for (Object object : params) {
					query.setParameter(index++, object);
				}
				return ((Long) query.uniqueResult()).intValue();
			}
		});
	}

	public List findByHql(String hql, Object... values) {
		return getHibernateTemplate().find(hql, values);
	}

	public Object findObjectByHql(String hql, Object... values) {
		List list = findByHql(hql, values);
		return list.isEmpty() ? null : list.get(0);
	}

	// 查询缓存:一般很少用,命中率低,没有查询条件
	public List findCacheByHql(final String hql) {
		return getHibernateTemplate().execute(new HibernateCallback<List<T>>() {
			public List<T> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				// 把上面查出来的结果放到缓存里面
				query.setCacheable(true);
				return query.list();
			}
		});
	}

}
