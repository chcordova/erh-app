package pe.cibertec.dawi.service;

import pe.cibertec.dawi.model.entity.AntecedenteFamiliarEntity;
import pe.cibertec.dawi.model.entity.PacienteEntity;

import java.util.List;

public interface AntecedenteFamiliarService extends CRUDService<AntecedenteFamiliarEntity> {

    List<AntecedenteFamiliarEntity> findAntecedenteFamiliarEntitiesByPaciente(PacienteEntity entity);

}
