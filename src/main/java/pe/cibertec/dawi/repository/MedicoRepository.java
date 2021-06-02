package pe.cibertec.dawi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.dawi.model.entity.MedicoEntity;

@Repository
public interface MedicoRepository extends CrudRepository<MedicoEntity, Long> { }
