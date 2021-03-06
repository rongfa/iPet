package iPet.action;

import iPet.model.User;
import iPet.service.IUserService;
import iPet.util.CommonUtil;
import iPet.util.JSON;
import iPet.util.MD5;
import iPet.util.UserContext;

import com.opensymphony.xwork2.ActionContext;

/**
 * @Description: 账号信息
 * @author rongfa
 * @date 2015-5-6 下午6:42:59
 */
public class AccountAction extends BaseAction {

	private static final long serialVersionUID = -4815757455393698890L;
	private String verification;
	private String password;
	private String affirmPassord;
	private IUserService userService;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setAffirmPassord(String affirmPassord) {
		this.affirmPassord = affirmPassord;
	}

	public String execute() throws Exception {
		return SUCCESS;
	}

	public String affirmPassord() throws Exception {
		return AFFIRMPASSORD;
	}

	public void setVerification(String verification) {
		this.verification = verification;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @Description: 获取验证码
	 * @return 返回视图
	 * @throws Exception
	 */
	public String getVerificationCode() throws Exception {
		String email = (String) ActionContext.getContext().getSession().get("email");
		JSON json = new JSON();
		String random = CommonUtil.getRandom();
		CommonUtil.send(email, random);
		ActionContext.getContext().getSession().put(email, random);
		putJSON(json);
		return AJAX;
	}

	/**
	 * @Description: 校验验证码
	 * @return 返回视图
	 * @throws Exception
	 */
	public String verification() throws Exception {
		JSON json = new JSON();
		String email = (String) ActionContext.getContext().getSession().get("email");
		String locationVerification = (String) ActionContext.getContext().getSession().get(email);
		if (!verification.equals(locationVerification)) {
			json.setSuccess(false);
			json.setMessage("验证码错误");
		}
		putJSON(json);
		return AJAX;
	}

	/**
	 * @Description: 确认密码（决定走注册还是找回密码入口）
	 * @return 返回视图
	 * @throws Exception
	 */
	public String affirm() throws Exception {
		String actionName = (String) ActionContext.getContext().getSession().get("actionName");
		if ("find".equals(actionName)) {
			return find();
		}
		if ("regist".equals(actionName)) {
			return regist();
		}
		return EXCEPTION;
	}

	/**
	 * @Description: 注册
	 * @return 返回视图
	 * @throws Exception
	 */
	public String regist() throws Exception {
		JSON json = new JSON();
		String email = (String) ActionContext.getContext().getSession().get("email");
		String locationVerification = (String) ActionContext.getContext().getSession().get(email);
		if (!verification.equals(locationVerification)) {
			json.setSuccess(false);
			json.setMessage("验证码错误");
		} else if (!password.equals(affirmPassord)) {
			json.setSuccess(false);
			json.setMessage("两次密码输入不正确");
		} else {
			User user = new User();
			user.setEmail(email);
			user.setName(email.substring(0, email.indexOf('@')));
			user.setSex(0);
			user.setPassword(MD5.encode(password));
			userService.save(user);
			UserContext.addCurrentUser(user);
		}
		putJSON(json);
		return AJAX;
	}

	/**
	 * @Description: 找回密码
	 * @return 返回视图
	 * @throws Exception
	 */
	public String find() throws Exception {
		JSON json = new JSON();
		String email = (String) ActionContext.getContext().getSession().get("email");
		String locationVerification = (String) ActionContext.getContext().getSession().get(email);
		if (!verification.equals(locationVerification)) {
			json.setSuccess(false);
			json.setMessage("验证码错误");
		} else if (!password.equals(affirmPassord)) {
			json.setSuccess(false);
			json.setMessage("两次密码输入不正确");
		} else {
			User user = userService.findUserByEmail(email);
			user.setPassword(MD5.encode(password));
			userService.update(user);
			UserContext.addCurrentUser(user);
		}
		putJSON(json);
		return AJAX;
	}
}
