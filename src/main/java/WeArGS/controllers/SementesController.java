package WeArGS.controllers;

import WeArGS.models.Sementes;
import WeArGS.repository.SementeRepository;
import WeArGS.service.SementesService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;



@RestController
@RequestMapping("/api/sementes")
public class SementesController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    SementeRepository sementesRepository;

    @Autowired
    SementesService sementesService;

    @GetMapping
    public List<Sementes> index(){
        return sementesRepository.findAll();
    }

    @GetMapping("/filtros")
    public ResponseEntity<Page<Sementes>> buscarSementesPorFiltros(
            @PageableDefault(size = 20) Pageable pageable, Sementes filtros) {

        return ResponseEntity.ok(sementesService.buscarSementesPorFiltros(pageable, filtros));
    }


    @PostMapping
    public ResponseEntity<Sementes> create(@RequestBody @Valid Sementes semente){
        log.info("cadastrando nova semente: " + semente);
        sementesRepository.save(semente);
        return ResponseEntity.status(HttpStatus.CREATED).body(semente);
    }

    @GetMapping("{id}")
    public ResponseEntity<Sementes> show(@PathVariable Long id){
        log.info("buscando semente com id " + id);
        return ResponseEntity.ok(getSementes(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Sementes> destroy(@PathVariable Long id){
        log.info("apagando semente com id " + id);
        sementesRepository.delete(getSementes(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Sementes> update(@PathVariable Long id, @RequestBody @Valid Sementes semente){
        log.info("alterando semente com id " + id);
        getSementes(id);
        semente.setSemente_id(id);
        sementesRepository.save(semente);
        return ResponseEntity.ok(semente);
    }

    private Sementes getSementes(Long id) {
        return sementesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "semente não encontrada"));
    }

}

