package br.com.monitoringDiabeticsApi.security.twoWayAuthentication.utils;

import java.math.BigInteger;

public class ConvertStringToBytes {

	public static byte[] hexStr2Bytes(String hex) {
		// HEX em Bytes
		byte[] bArray = new BigInteger("10" + hex, 16).toByteArray();
		byte[] ret = new byte[bArray.length - 1];
		for (int i = 0; i < ret.length; i++)
			ret[i] = bArray[i + 1];
		return ret;
	}
}
