package WeArGS.controllers;

import WeArGS.exception.RestNotFoundException;
import WeArGS.models.Sementes;
import WeArGS.models.Solo;
import WeArGS.repository.SementeRepository;
import WeArGS.repository.SoloRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/api/solo")
@SecurityRequirement(name = "bearer-key")
public class SoloController {


    List<Sementes> sementes = new ArrayList<>();

    @Autowired
    SoloRepository soloRepository;

    @Autowired
    SementeRepository sementeRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String busca, @ParameterObject @PageableDefault(size = 5) Pageable pageable){
        Page<Solo> solo = (busca == null)?
                soloRepository.findAll(pageable):
                soloRepository.findByDescricaoContaining(busca, pageable);

        return assembler.toModel(solo.map(Solo::toModel));
    }


    @PostMapping
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "solo cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "erro na validação dos dados da requisição")
    })
    public ResponseEntity<Object> create(@RequestBody @Valid Solo solo){
        log.info("cadastrando novo solo: " + solo);
        soloRepository.save(solo);
        solo.setSemente(sementeRepository.findById(solo.getSemente().getSolo_id()).get());
        return ResponseEntity
                .created(solo.toModel().getRequiredLink("self").toUri())
                .body(solo.toModel());
    }
    @GetMapping("{id}")
    @Operation(
            summary = "Detalhes do solo",
            description = "Retorna os dados de um solo com id especificado"
    )
    public EntityModel<Solo> show(@PathVariable Long id){
        log.info("buscando solo com id " + id);
        var solo = soloRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "solo não encontrado"));

        return solo.toModel();

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Solo> destroy(@PathVariable Long id){
        log.info("apagando solo com id " + id);
        var despesa = soloRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("solo não encontrado"));

        soloRepository.delete(despesa);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("{id}")
    public EntityModel<Solo> update(@PathVariable Long id, @RequestBody @Valid Solo solo){
        log.info("alterando solo com id " + id);
        soloRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("solo não encontrado"));

        solo.setSolo_id(id);
        soloRepository.save(solo);

        return solo.toModel();

    }

}
