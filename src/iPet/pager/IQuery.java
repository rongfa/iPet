package iPet.pager;

import java.util.List;

public interface IQuery {

	public abstract int getCurrentPage();

	public abstract void setCurrentPage(int currentPage);

	public abstract int getPageSize();

	public abstract void setPageSize(int pageSize);

	// 直接给BaseDao使用:o.username like ? and o.email like ?
	public abstract String getWhere();

	// 直接给BaseDao使用: %admin%,%admin%
	public abstract List<Object> getParams();

}