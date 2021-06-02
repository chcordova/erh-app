package pe.cibertec.dawi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.cibertec.dawi.model.entity.EnfermedadEntity;
import pe.cibertec.dawi.model.entity.TratamientoEntity;
import pe.cibertec.dawi.repository.TratamientoRepository;

import java.util.List;

@Service
@Transactional
public class TratamientoServiceImpl implements TratamientoService {

    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Override
    public List<TratamientoEntity> listAll() {
        return (List<TratamientoEntity>) tratamientoRepository.findAll();
    }

    @Override
    public TratamientoEntity getById(Long id) {
        return tratamientoRepository.findById(id).orElseThrow();
    }

    @Override
    public TratamientoEntity saveOrUpdate(TratamientoEntity entity) {
        return tratamientoRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        tratamientoRepository.delete(this.getById(id));
    }

    @Override
    public List<TratamientoEntity> findTratamientoEntitiesByEnfermedad(EnfermedadEntity entity) {
        return tratamientoRepository.findTratamientoEntitiesByEnfermedad(entity);
    }
}
