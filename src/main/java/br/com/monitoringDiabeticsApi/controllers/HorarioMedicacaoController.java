package br.com.monitoringDiabeticsApi.controllers;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.monitoringDiabeticsApi.models.HorarioMedicacao;
import br.com.monitoringDiabeticsApi.services.HorarioMedicacaoService;

@RestController
@RequestMapping("/horario-medicacoes")
public class HorarioMedicacaoController {

	@Autowired
	private HorarioMedicacaoService horarioMedicacaoService;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		return ResponseEntity.status(200).body(this.horarioMedicacaoService.findAll());
	}

	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody HorarioMedicacao horarioMedicacao) {
		
		horarioMedicacao = this.horarioMedicacaoService.save(horarioMedicacao);
		return ResponseEntity.ok(horarioMedicacao);
	}
	
	@PutMapping("/{id}/fim-medicacao")
	public ResponseEntity<?> setFimMedicacao(@PathVariable("id") Integer idHorarioMedicacao){
		try {
			this.horarioMedicacaoService.setFimMedicacao(idHorarioMedicacao);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("mensagem", "Pronto, a partir das próximas 24 horas, você não será mais notificado da sua medicação!");
		return ResponseEntity.ok(jsonObject.toString());
		}catch(Exception e) {
			return ResponseEntity.status(500).build();
		}
	}
}
