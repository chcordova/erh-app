package pe.cibertec.dawi.service;

import pe.cibertec.dawi.model.entity.DiscapacidadEntity;
import pe.cibertec.dawi.model.entity.PacienteEntity;

import java.util.List;

public interface DiscapacidadService extends CRUDService<DiscapacidadEntity> {

    List<DiscapacidadEntity> findDiscapacidadEntitiesByPaciente(PacienteEntity entity);

}
