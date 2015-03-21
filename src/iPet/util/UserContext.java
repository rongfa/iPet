package iPet.util;

import javax.servlet.http.Cookie;
import iPet.model.User;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;

public class UserContext {
	public final static String USER_IN_SESSION = "user";
	public final static String USER_IN_COOKIE = "user_iPet";

	public static User getCurrentUser() {
		Object user = ActionContext.getContext().getSession() .get(USER_IN_SESSION);
		return user == null ? null : (User) user;
	}

	public static void addCurrentUser(User user) {
		ActionContext.getContext().getSession().put(USER_IN_SESSION, user);
		Cookie cookie = new Cookie(USER_IN_COOKIE, user.getName());
		cookie.setMaxAge(30 * 24 * 60 * 60);
		ServletActionContext.getResponse().addCookie(cookie);
	}

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
