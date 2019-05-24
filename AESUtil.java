import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.DecoderException;

public enum AESUtil {
	;
	// 共通鍵
	private static final String ENCRYPTION_KEY = "485de0e185028e9906e6131aaf210104";
	private static final String ENCRYPTION_IV  = "c22bd245f41dcace6fb91c2bdf478e0f";

	public static String encrypt(String src) {
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, makeKey(), makeIv());
			// return Base64.encodeBytes(cipher.doFinal(src.getBytes()));
			return Base64.encodeBase64String(cipher.doFinal(src.getBytes()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String decrypt(String src) {
		String decrypted = "";
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, makeKey(), makeIv());
			// decrypted = new String(cipher.doFinal(Base64.decode(src)));
			decrypted = new String(cipher.doFinal(Base64.decodeBase64(src)));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return decrypted;
	}

	static AlgorithmParameterSpec makeIv() {
		return new IvParameterSpec(hex(ENCRYPTION_IV));
	}

	static Key makeKey() {
		byte[] key = hex(ENCRYPTION_KEY);
		return new SecretKeySpec(key, "AES");
	}

	static byte[] hex(String str) {
		try {
				return Hex.decodeHex(str.toCharArray());
		} catch (DecoderException e) {
				throw new IllegalStateException(e);
		}
	}
}
