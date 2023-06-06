package WeArGS.service;

import WeArGS.controllers.SementesController;
import WeArGS.especification.SementesSpecification;
import WeArGS.exception.ParametroInvalidoException;
import WeArGS.models.Sementes;
import WeArGS.repository.SementeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class SementesService {

    public Page<Sementes> buscarSementesPorFiltros(Pageable p, Sementes filtros) {

        if(filtros.getTipo_semente() != null && filtros.getTipo_semente().length() < 3) {
            throw new ParametroInvalidoException("O parâmetro para pesquisa deve ter no mínimo 3 caracteres ");
        }

        Page<Sementes> sementesEntities = SementeRepository
                .findAll(new SementesSpecification(filtros ), p);
        return sementesEntities;

    }
}
