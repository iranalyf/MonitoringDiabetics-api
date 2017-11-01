package br.com.monitoringDiabeticsApi.utils;

import java.time.LocalDate;

public class UtilsTestes {

	public static void main(String[] args) {
		LocalDate ultimaModificacao = LocalDate.of(2017, 10, 14);

		boolean after = ultimaModificacao.isAfter(LocalDate.now().minusDays(10));

		System.out.println(after);

	}

}
