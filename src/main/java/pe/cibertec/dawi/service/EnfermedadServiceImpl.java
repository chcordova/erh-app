package pe.cibertec.dawi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.cibertec.dawi.model.entity.EnfermedadEntity;
import pe.cibertec.dawi.model.entity.PacienteEntity;
import pe.cibertec.dawi.repository.EnfermedadRepository;

import java.util.List;

@Service
@Transactional
public class EnfermedadServiceImpl implements EnfermedadService {

    @Autowired
    private EnfermedadRepository enfermedadRepository;


    @Override
    public List<EnfermedadEntity> listAll() {
        return (List<EnfermedadEntity>) enfermedadRepository.findAll();
    }

    @Override
    public EnfermedadEntity getById(Long id) {
        return enfermedadRepository.findById(id).orElseThrow();
    }

    @Override
    public EnfermedadEntity saveOrUpdate(EnfermedadEntity entity) {
        return enfermedadRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        enfermedadRepository.delete(this.getById(id));
    }

    @Override
    public List<EnfermedadEntity> findEnfermedadEntitiesByPaciente(PacienteEntity entity) {
        return enfermedadRepository.findEnfermedadEntitiesByPaciente(entity);
    }

}
