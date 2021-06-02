package pe.cibertec.dawi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.dawi.model.entity.AntecedenteFamiliarEntity;
import pe.cibertec.dawi.model.entity.PacienteEntity;

import java.util.List;

@Repository
public interface AntecedenteFamiliarRepository extends CrudRepository<AntecedenteFamiliarEntity, Long> {

    List<AntecedenteFamiliarEntity> findAntecedenteFamiliarEntitiesByPaciente(PacienteEntity entity);

}
