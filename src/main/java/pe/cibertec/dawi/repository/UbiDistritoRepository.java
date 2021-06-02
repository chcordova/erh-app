package pe.cibertec.dawi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.dawi.model.entity.UbiDistritoEntity;

@Repository
public interface UbiDistritoRepository extends CrudRepository<UbiDistritoEntity, Long> { }
