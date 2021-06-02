package pe.cibertec.dawi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.dawi.model.entity.EnfermedadEntity;
import pe.cibertec.dawi.model.entity.PacienteEntity;

import java.util.List;

@Repository
public interface EnfermedadRepository extends CrudRepository<EnfermedadEntity, Long> {

    List<EnfermedadEntity> findEnfermedadEntitiesByPaciente(PacienteEntity entity);

}
