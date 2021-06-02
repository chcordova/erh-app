package pe.cibertec.dawi.service;

import pe.cibertec.dawi.model.entity.CuidadorEntity;
import pe.cibertec.dawi.model.entity.PacienteEntity;

import java.util.List;

public interface CuidadorService extends CRUDService<CuidadorEntity> {

    List<CuidadorEntity> findCuidadorEntitiesByPaciente(PacienteEntity entity);

}
