package pe.cibertec.dawi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.dawi.model.entity.Cie10BloqueEntity;

@Repository
public interface Cie10BloqueRepository extends CrudRepository<Cie10BloqueEntity, Long> {
}
