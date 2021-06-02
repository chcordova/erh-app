package pe.cibertec.dawi.service;

import pe.cibertec.dawi.model.entity.EnfermedadEntity;
import pe.cibertec.dawi.model.entity.TratamientoEntity;

import java.util.List;

public interface TratamientoService extends CRUDService<TratamientoEntity> {

    List<TratamientoEntity> findTratamientoEntitiesByEnfermedad(EnfermedadEntity entity);

}
