package pe.cibertec.dawi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.dawi.model.entity.DocumentoEnfermedadEntity;

@Repository
public interface DocumentoEnfermedadRepository extends CrudRepository<DocumentoEnfermedadEntity, Long> { }
