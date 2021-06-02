package pe.cibertec.dawi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.dawi.model.entity.DirectorEntity;

@Repository
public interface DirectorRepository extends CrudRepository<DirectorEntity, Long> { }
