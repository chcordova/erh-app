package pe.cibertec.dawi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.dawi.model.entity.Cie10CarpetaEntity;

@Repository
public interface Cie10CarpetaRepository extends CrudRepository<Cie10CarpetaEntity, Long> {
}
