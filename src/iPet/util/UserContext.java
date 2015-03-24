package iPet.util;

import javax.servlet.http.Cookie;
import iPet.model.User;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;

/**
 * @Description: 用户操作工具类
 * @author rongfa
 * @date 2015-3-24 下午9:29:00
 */
public class UserContext {
	public final static String USER_IN_SESSION = "user";
	public final static String USER_IN_COOKIE = "user_iPet";

	/**
	 * @Description: 从session中获取当前用户
	 * @return 用户信息
	 */
	public static User getCurrentUser() {
		Object user = ActionContext.getContext().getSession().get(USER_IN_SESSION);
		return user == null ? null : (User) user;
	}

	/**
	 * @Description:添加当前用户在session和cookie中
	 * @param user
	 *            需要添加的对象
	 */
	public static void addCurrentUser(User user) {
		ActionContext.getContext().getSession().put(USER_IN_SESSION, user);
		Cookie cookie = new Cookie(USER_IN_COOKIE, user.getName());
		cookie.setMaxAge(30 * 24 * 60 * 60);
		ServletActionContext.getResponse().addCookie(cookie);
	}

	/**
	 * @Description:把当前对象从seesion和cookie中移除
	 */
	public static void removeCurrentUser() {
		ActionContext.getContext().getSession().remove(USER_IN_SESSION);
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		for (Cookie cookie : cookies) {
			if (UserContext.USER_IN_COOKIE.equals(cookie.getName())) {
				cookie.setMaxAge(0);
				ServletActionContext.getResponse().addCookie(cookie);
			}
		}
	}
}
