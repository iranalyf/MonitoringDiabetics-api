package br.com.monitoringDiabeticsApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import br.com.monitoringDiabeticsApi.config.properties.MonitDiabApiProperty;
import br.com.monitoringDiabeticsApi.services.InativarPacienteService;

@SpringBootApplication
@EnableConfigurationProperties(MonitDiabApiProperty.class)
public class MonitoringDiabeticsApiApplication {

	@Autowired
	private InativarPacienteService inativarPacienteService;

	public static void main(String[] args) {
		SpringApplication.run(MonitoringDiabeticsApiApplication.class, args);
	}

	@Bean
	public int validarInatividadeDePacientes() {
		this.inativarPacienteService.inativarPaciente();
		return 0;
	}
}
