package br.com.monitoringDiabeticsApi.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.monitoringDiabeticsApi.models.Paciente;

@Service
public class InativarPacienteService {

	@Autowired
	private PacienteService pacienteService;

	public void inativarPaciente() {
		List<Paciente> allPacientes = this.pacienteService.findAll();

		List<Paciente> pacientesParaSeremAtualizadosParaInativo = new ArrayList<>();

		for (Paciente paciente : allPacientes) {
			//verifica se o ultimo registro do paciente é superior a data atual menos 30 dias
			if(paciente.getUltimoRegistro() != null) {
				System.out.println("data ultimo registro não esta nulo");
				if (paciente.getUltimoRegistro().isBefore(LocalDate.now().minusDays(30))) {
					pacientesParaSeremAtualizadosParaInativo.add(paciente);
				}
			}
		}

		// implementar uma Thread de 500 mls
		if (!pacientesParaSeremAtualizadosParaInativo.isEmpty()) {
			System.out.println("vou precisar atualizar");
			pacientesParaSeremAtualizadosParaInativo.forEach(p -> {
				System.out.println(p.getPrimeiroNome());
				this.pacienteService.atualizarSituacaoPacienteInativo(p.getCodigo());
				
			});
		}
	}
}
