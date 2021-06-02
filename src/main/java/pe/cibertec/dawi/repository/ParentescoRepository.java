package pe.cibertec.dawi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.dawi.model.entity.ParentescoEntity;

@Repository
public interface ParentescoRepository extends CrudRepository<ParentescoEntity, Long> {
}
