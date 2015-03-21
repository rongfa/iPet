package iPet.pager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 出来公共的查询信息:当前页面,一页显示的条数,hql语句
 */
@SuppressWarnings("all")
public abstract class BaseQuery implements IQuery {
	// 当前页码
	private int currentPage = 1;
	// 一页显示的条数
	private int pageSize = 10;
	// select o from Employee o where o.username like ? and o.email like ?
	// %admin%,%admin%
	// 封装查询条件的hql:具体的查询条件来自子类
	private StringBuilder builder = new StringBuilder();
	// 封装查询条件参数的值
	private List params = new ArrayList();

	// 让子类必须重写,在里面先判断是否有条件,有添加条件
	protected abstract void addWhere();

	// 让子类直接把条件放到父类的参数builder,params里面去
	// select o from OrderBill o where o.vdate between ? and ?
	protected void addWhere(String hql, Object... objects) {
		// 第2-n次的条件
		if (builder.length() > 0) {
			builder.append(" and ").append(hql);
		} else {
			builder.append(hql);
		}
		// 容易些错的地方:addAll,Arrays.asList
		params.addAll(Arrays.asList(objects));
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getWhere() {
		addWhere();
		return builder.toString();
	}

	public List getParams() {
		return params;
	}

}
