package iPet.action;

import iPet.service.IUserService;
import iPet.util.CommonUtil;
import iPet.util.JSON;
import iPet.util.mail.SimpleMailSender;

import com.opensymphony.xwork2.ActionContext;

/**
 * @author Administrator
 */
public class FindAction extends BaseAction {
	private static final long serialVersionUID = -6904321704701247876L;
	private IUserService userService;
	private String email;

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String execute() throws Exception {
		return SUCCESS;
	}

	public String getVerificationCode() throws Exception {
		ActionContext.getContext().getSession().put("actionName", "find");
		ActionContext.getContext().getSession().put("email", email);
		JSON json = new JSON();
		if (!userService.findUserByEmail(email)) {
			json.setSuccess(false);
			json.setMessage("该用户不存在");
		}
		 String random = CommonUtil.getRandom();
		SimpleMailSender.send(email, random);
		ActionContext.getContext().getSession().put(email,random);
		putJSON(json);
		return AJAX;
	}

}
