package br.com.monitoringDiabeticsApi.security.twoWayAuthentication;

import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

import br.com.monitoringDiabeticsApi.security.twoWayAuthentication.utils.ConvertStringToBytes;
import br.com.monitoringDiabeticsApi.security.twoWayAuthentication.utils.ConvertStringToHex;

@Component
public class TOTP {

	public String gerarToken(String chaveSecreta) throws NoSuchAlgorithmException {

		//converte a chave de String para Hex
		String chaveConvertida = ConvertStringToHex.convertStringToHex(chaveSecreta);
		
		//tempo para gerar uma nova
		long timeWindow = 60L;
		
		//tempo exato
		long exactTime = (System.currentTimeMillis() / 1000L);
		long preRound = (long) (exactTime / timeWindow);
		String roundedTime = Long.toHexString(preRound).toUpperCase();

		while (roundedTime.length() < 16) {
			roundedTime = "0" + roundedTime;
		}

		byte[] hash = HMAC.hmac(ConvertStringToBytes.hexStr2Bytes(chaveConvertida), ConvertStringToBytes.hexStr2Bytes(roundedTime));
		int offset = hash[hash.length - 1] & 0xf;
		int otp = 
				((hash[offset + 0] & 0x7f) << 24) |
				((hash[offset + 1] & 0xff) << 16) |
				((hash[offset + 2] & 0xff) <<  8) |
				(hash[offset + 3] & 0xff);
				
		otp = otp % 1000000;
		
		String resultado = Integer.toString(otp);
		
		while(resultado.length() < 6){
			resultado = "0" + resultado;
		}
		
		return resultado;
	}
}
