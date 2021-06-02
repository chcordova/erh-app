package pe.cibertec.dawi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.dawi.model.entity.DiscapacidadEntity;
import pe.cibertec.dawi.model.entity.PacienteEntity;

import java.util.List;

@Repository
public interface DiscapacidadRepository extends CrudRepository<DiscapacidadEntity, Long> {

    List<DiscapacidadEntity> findDiscapacidadEntitiesByPaciente(PacienteEntity entity);

}
