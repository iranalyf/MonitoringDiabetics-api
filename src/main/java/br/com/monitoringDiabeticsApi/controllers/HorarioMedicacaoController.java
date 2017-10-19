package br.com.monitoringDiabeticsApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.monitoringDiabeticsApi.models.HorarioMedicacao;
import br.com.monitoringDiabeticsApi.services.HorarioMedicacaoService;

@RestController
@RequestMapping("/horario-medicacao")
public class HorarioMedicacaoController {

	@Autowired
	private HorarioMedicacaoService horarioMedicacaoService;

	@GetMapping
	public ResponseEntity<List<HorarioMedicacao>> findAll() {
		return ResponseEntity.status(200).body(this.horarioMedicacaoService.findAll());
	}

	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody HorarioMedicacao horarioMedicacao) {
		try {
			horarioMedicacao = this.horarioMedicacaoService.save(horarioMedicacao);
			return ResponseEntity.ok(horarioMedicacao);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping("/{id}/fimMedicacao")
	public ResponseEntity<?> setFimMedicacao(@PathVariable("id") Integer idHorarioMedicacao){
		try {
			this.horarioMedicacaoService.setFimMedicacao(idHorarioMedicacao);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sucesso", "Fim da Medicação");
			jsonObject.put("mensagem", "Pronto, a partir das próximas 24 horas, você não será mais notificado da sua medicação, ok");
		return ResponseEntity.ok(jsonObject);
		}catch(Exception e) {
			return ResponseEntity.status(500).build();
		}
	}
}
