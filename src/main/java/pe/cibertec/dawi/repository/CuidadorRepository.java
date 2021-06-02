package pe.cibertec.dawi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.dawi.model.entity.CuidadorEntity;
import pe.cibertec.dawi.model.entity.PacienteEntity;

import java.util.List;

@Repository
public interface CuidadorRepository extends CrudRepository<CuidadorEntity, Long> {

/*    @Query("select c from CuidadorEntity c inner join c.pacientes p where p.id =:pacienteId")
    List<CuidadorEntity> findByPacienteId(@Param("pacienteId") Long pacienteId);*/

    List<CuidadorEntity> findCuidadorEntitiesByPaciente(PacienteEntity entity);

}
