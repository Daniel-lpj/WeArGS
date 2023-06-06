package WeArGS.controllers;

import WeArGS.models.ClimaPlantacao;
import WeArGS.repository.ClimaPlantacaoRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/climaPlantacao")
public class ClimaPlantacaoController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ClimaPlantacaoRepository climaPlantacaoRepositoryRepository;

    @GetMapping
    public List<ClimaPlantacao> index(){
        return climaPlantacaoRepositoryRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<ClimaPlantacao> create(@RequestBody @Valid ClimaPlantacao climaPlantacao){
        log.info("cadastrando novo clima para plantação: " + climaPlantacao);
        climaPlantacaoRepositoryRepository.save(climaPlantacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(climaPlantacao);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClimaPlantacao> show(@PathVariable Long id){
        log.info("buscando clima para plantação com id " + id);
        return ResponseEntity.ok(getClimaPlantacao(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ClimaPlantacao> destroy(@PathVariable Long id){
        log.info("apagando clima para plantação com id " + id);
        climaPlantacaoRepositoryRepository.delete(getClimaPlantacao(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<ClimaPlantacao> update(@PathVariable Long id, @RequestBody @Valid ClimaPlantacao climaPlantacao){
        log.info("alterando clima para plantação com id " + id);
        getClimaPlantacao(id);
        climaPlantacao.setClima_plantacao_id(id);
        climaPlantacaoRepositoryRepository.save(climaPlantacao);
        return ResponseEntity.ok(climaPlantacao);
    }

    private ClimaPlantacao getClimaPlantacao(Long id) {
        return climaPlantacaoRepositoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "clima para plantação não encontrado"));
    }
}
