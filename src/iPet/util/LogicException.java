package iPet.util;

/**
 * @Description:自定义异常
 * @author rongfa
 * @date 2015-3-24 下午9:33:09
 */
public class LogicException extends RuntimeException {
	private static final long serialVersionUID = 5004570256403436329L;

	public LogicException(String msg) {
		super(msg);
	}
}
