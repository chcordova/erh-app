package pe.cibertec.dawi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.dawi.model.entity.UbiProvinciaEntity;

@Repository
public interface UbiProvinciaRepository extends CrudRepository<UbiProvinciaEntity, Long> {
}
