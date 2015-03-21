package iPet.pager;

import java.util.ArrayList;
import java.util.List;

/**
 * 把查询后的分页结果封装到PageResult
 */
public class PageResult<T> {
	// 当前页码
	private int currentPage;
	// 一页显示的条数
	private int pageSize;
	// 总条数
	private int totalRows;
	// 总页数:计算出来
	private int totalPages;
	// 当前页的数据
	private List<T> rows = new ArrayList<T>();

	public PageResult() {

	}

	public PageResult(int currentPage, int pageSize, int totalRows) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalRows = totalRows;

		// currentPage和pageSize最小值必须是1
		this.currentPage = Math.max(this.currentPage, 1);
		this.pageSize = Math.max(this.pageSize, 1);

		// 总页数:计算出来
		this.totalPages = (this.totalRows + this.pageSize - 1) / this.pageSize;

		// 错误处理
		// 当前页面不能大于总页数
		this.currentPage = Math.min(this.currentPage, this.totalPages);
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

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getTotal() {
		return totalRows;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "PageResult [currentPage=" + currentPage + ", pageSize="
				+ pageSize + ", totalRows=" + totalRows + ", totalPages="
				+ totalPages + ", rows=" + rows.size() + "]";
	}

}
