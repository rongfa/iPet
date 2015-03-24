package iPet.action;

import iPet.util.UserContext;
import javax.servlet.http.Cookie;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @Description: 拦截器
 * @author rongfa
 * @date 2015-3-24 下午8:38:34
 */
public class Interceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 2878389311173605851L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Object user = ActionContext.getContext().getSession().get(UserContext.USER_IN_SESSION);
		if (user == null) {
			Cookie[] cookies = ServletActionContext.getRequest().getCookies();
			if (cookies == null) {
				return Action.LOGIN;
			}
			for (Cookie cookie : cookies) {
				if (UserContext.USER_IN_COOKIE.equals(cookie.getName())) {
					if (cookie.getValue() != null && !cookie.getValue().isEmpty()) {
						ActionContext.getContext().getSession().put(UserContext.USER_IN_SESSION, user);
						return invocation.invoke();
					}
				}
			}
			return Action.LOGIN;
		}
		return invocation.invoke();
	}
}
