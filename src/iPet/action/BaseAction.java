package iPet.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * @Description: Action父类 定义常量
 * @author rongfa
 * @date 2015-3-24 下午8:35:56
 */
public abstract class BaseAction extends ActionSupport implements Preparable {
	private static final long serialVersionUID = 2418841497790986417L;
	protected static final String HOME = "home";
	protected static final String INDEX = "index";
	protected static final String AJAX = "ajax";
	protected static final String AFFIRMPASSORD = "affirmPassord";
	protected static final String EXCEPTION = "exception";

	public String execute() throws Exception {
		return INDEX;
	}

	/**
	 * @Description: 设置值到页面
	 * @param key
	 * @param value
	 */
	protected void putContext(String key, Object value) {
		ActionContext.getContext().put(key, value);
	}

	/**
	 * @Description: 通过json格式传值
	 * @param value
	 */
	protected void putJSON(Object value) {
		putContext("jsonData", value);
	}

	@Override
	public void prepare() throws Exception {
	}
}
