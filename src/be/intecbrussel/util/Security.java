package be.intecbrussel.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {
	
	
	// Als je een hash maakt van een String 
	// heb je een zekere veiligheid.
	// Als je een hash maakt van een hash van
	// een string heb je meer veiligheid.
	// als je een hash maakt van een hash van
	// een hash van een string heb je nog meer
	// veiligheid... enz.

	
	// de lightHash hashed 'slechts' twee keer
	public String lightHash(String bron) {

		for (int i = 0; i < 2; i++) {

			bron = md5(bron);

		}

		return bron;

	}

	// de heavyHash hashed tien keer
	public String heavyHash(String bron) {

		for (int i = 0; i < 10; i++) {

			bron = md5(bron);

		}

		return bron;

	}
	
	// de hashfunctie (deze code moet je niet begrijpen)
	// Hier word een MD5 hash gemaakt van een meegeven
	// String.
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
