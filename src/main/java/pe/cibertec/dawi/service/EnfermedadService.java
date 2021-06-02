package pe.cibertec.dawi.service;

import pe.cibertec.dawi.model.entity.EnfermedadEntity;
import pe.cibertec.dawi.model.entity.PacienteEntity;

import java.util.List;

public interface EnfermedadService extends CRUDService<EnfermedadEntity> {

    List<EnfermedadEntity> findEnfermedadEntitiesByPaciente(PacienteEntity entity);

}
