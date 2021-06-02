package pe.cibertec.dawi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.dawi.model.entity.OrphanetEntity;

@Repository
public interface OrphanetRepository extends CrudRepository<OrphanetEntity, Long> {
}
