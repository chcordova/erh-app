package pe.cibertec.dawi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.dawi.model.entity.DocumentoEntity;

@Repository
public interface DocumentoRepository extends CrudRepository<DocumentoEntity, Long> { }
