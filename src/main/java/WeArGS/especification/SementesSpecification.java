package WeArGS.especification;

import WeArGS.models.Sementes;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class SementesSpecification implements Specification<Sementes>  {

    private final transient Sementes filtros;

    public SementesSpecification(Sementes filtros) {
        this.filtros = filtros;
    }

    @Override
    public Predicate toPredicate(Root<Sementes> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
