package iPet.action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


/**
 * 拦截器
 * @author rongfa
 */
public class Interceptor extends AbstractInterceptor {
	private static final long serialVersionUID = -94165169194099004L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		return invocation.invoke();
	}

}
