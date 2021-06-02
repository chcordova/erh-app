package pe.cibertec.dawi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.cibertec.dawi.model.entity.DiscapacidadEntity;
import pe.cibertec.dawi.model.entity.PacienteEntity;
import pe.cibertec.dawi.repository.DiscapacidadRepository;

import java.util.List;

@Service
@Transactional
public class DiscapacidadServiceImpl implements DiscapacidadService {

    @Autowired
    private DiscapacidadRepository discapacidadRepository;

    @Override
    public List<DiscapacidadEntity> listAll() {
        return (List<DiscapacidadEntity>) discapacidadRepository.findAll();
    }

    @Override
    public DiscapacidadEntity getById(Long id) {
        return discapacidadRepository.findById(id).orElseThrow();
    }

    @Override
    public DiscapacidadEntity saveOrUpdate(DiscapacidadEntity entity) {
        return discapacidadRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        discapacidadRepository.delete(this.getById(id));
    }

    @Override
    public List<DiscapacidadEntity> findDiscapacidadEntitiesByPaciente(PacienteEntity entity) {
        return discapacidadRepository.findDiscapacidadEntitiesByPaciente(entity);
    }
}
