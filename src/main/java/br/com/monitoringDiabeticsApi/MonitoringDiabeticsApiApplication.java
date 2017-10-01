package br.com.monitoringDiabeticsApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.monitoringDiabeticsApi.config.properties.MonitDiabApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(MonitDiabApiProperty.class)
public class MonitoringDiabeticsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitoringDiabeticsApiApplication.class, args);
	}
}
