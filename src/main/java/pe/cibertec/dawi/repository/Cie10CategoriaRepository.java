package pe.cibertec.dawi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.dawi.model.entity.Cie10CategoriaEntity;

@Repository
public interface Cie10CategoriaRepository extends CrudRepository<Cie10CategoriaEntity, Long> {
}
