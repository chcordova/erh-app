package pe.cibertec.dawi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.dawi.model.entity.UbiDepartamentoEntity;

@Repository
public interface UbiDepartamentoRepository extends CrudRepository<UbiDepartamentoEntity, Long> { }
