package br.com.monitoringDiabeticsApi.security.twoWayAuthentication.utils;

public class ConvertStringToHex {

	public static String convertStringToHex(String str) {
		// converter String para HEX
		char[] chars = str.toCharArray();

		StringBuffer hex = new StringBuffer();
		for (int i = 0; i < chars.length; i++) {
			hex.append(Integer.toHexString((int) chars[i]));
		}

		return hex.toString();
	}
}
