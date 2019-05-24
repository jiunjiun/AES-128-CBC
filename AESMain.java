public class AESMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String data = "haha|yeye";
		String encrypted = AESUtil.encrypt(data);
		String decrypted = AESUtil.decrypt(encrypted);
		System.out.println("Key: " + AESUtil.ENCRYPTION_KEY);
		System.out.println("IV: " + AESUtil.ENCRYPTION_IV);
		System.out.println("data: " + data);
		System.out.println("encrypted: " + encrypted);
		System.out.println("decrypted: " + decrypted);
	}
}
