package iPet.util;

/**
 * @Description: 封装json信息
 * @author rongfa
 * @date 2015-3-24 下午9:33:50
 */
public class JSON {

	/**
	 * 返回json的状态
	 */
	private boolean success = true;
	/**
	 * 返回信息
	 */
	private String message;
	/**
	 * 返回数据
	 */
	private Object data;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
