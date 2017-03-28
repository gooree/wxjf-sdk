
public class Test {

	public static void main(String[] args) {
		String authCode = "151234567890111111";
		if (authCode.matches("^1[0-5]\\d{16}$")) {
			System.out.println("wxpay");
		} else if (authCode.matches("^28\\d{16}$")) {
			System.out.println("alipay");
		} else {
			System.out.println("无效授权码");
		}
	}

}
