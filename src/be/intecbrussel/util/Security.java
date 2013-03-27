package be.intecbrussel.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {

	public String lightHash(String bron) {

		for (int i = 0; i < 2; i++) {

			bron = md5(bron);

		}

		return bron;

	}

	public String heavyHash(String bron) {

		for (int i = 0; i < 10; i++) {

			bron = md5(bron);

		}

		return bron;

	}

	public String md5(String bron) {

		StringBuffer sb = null;

		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");

			md.update(bron.getBytes());

			byte byteData[] = md.digest();

			sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
						.substring(1));
			}

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return sb.toString();

	}

}
