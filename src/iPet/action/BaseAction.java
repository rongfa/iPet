package iPet.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * Action父类
 * @author rongfa
 */
public abstract class BaseAction extends ActionSupport implements Preparable {
	private static final long serialVersionUID = 2418841497790986417L;
	protected static final String HOME = "home";
	protected static final String INDEX = "index";
	protected static final String AJAX = "ajax";
	protected static final String AFFIRMPASSORD = "affirmPassord";

	public String execute() throws Exception {
		return INDEX;
	}

	protected void putContext(String key, Object value) {
		ActionContext.getContext().put(key, value);
	}

	protected void putJSON(Object value) {
		putContext("jsonData", value);
	}

	@Override
	public void prepare() throws Exception {
	}
}
