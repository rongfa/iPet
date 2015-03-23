package iPet.action;

import iPet.service.IUserService;
import iPet.util.CommonUtil;
import iPet.util.JSON;
import iPet.util.mail.SimpleMailSender;

import com.opensymphony.xwork2.ActionContext;

/**
 * @author Administrator
 */
public class AffirmPassordAction extends BaseAction {

	private static final long serialVersionUID = -6269986748707985581L;
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

	public String getVerificationCode() throws Exception {
		String email = (String) ActionContext.getContext().getSession()
				.get("email");
		JSON json = new JSON();
		String random = CommonUtil.getRandom();
		SimpleMailSender.send(email, random);
		ActionContext.getContext().getSession().put(email, random);
		putJSON(json);
		return AJAX;
	}

	public String regist() throws Exception {
		JSON json = new JSON();
		String email = (String) ActionContext.getContext().getSession()
				.get("email");
		String locationVerification = (String) ActionContext.getContext()
				.getSession().get(email);
		if (!verification.equals(locationVerification)) {
			json.setSuccess(false);
			json.setMessage("验证码错误");
		} else if (!password.equals(affirmPassord)) {
			json.setSuccess(false);
			json.setMessage("两次密码输入不正确");
		} else {
			userService.regist(email, password);
			// UserContext.addCurrentUser(user);
		}
		putJSON(json);
		return AJAX;
	}

}
