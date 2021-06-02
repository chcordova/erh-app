package pe.cibertec.dawi.service;

import pe.cibertec.dawi.model.entity.PacienteEntity;

public interface PacienteService extends CRUDService<PacienteEntity> {

    PacienteEntity findPacienteEntityByNroDocumento(String nroDocuemento);
}
