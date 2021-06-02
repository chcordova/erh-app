package pe.cibertec.dawi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.cibertec.dawi.model.entity.CuidadorEntity;
import pe.cibertec.dawi.model.entity.PacienteEntity;
import pe.cibertec.dawi.repository.CuidadorRepository;

import java.util.List;

@Service
@Transactional
public class CuidadorServiceImpl implements CuidadorService {

    @Autowired
    private CuidadorRepository cuidadorRepository;

    @Override
    public List<CuidadorEntity> listAll() {
        return (List<CuidadorEntity>) cuidadorRepository.findAll();
    }

    @Override
    public CuidadorEntity getById(Long id) {
        return cuidadorRepository.findById(id).orElseThrow();
    }

    @Override
    public CuidadorEntity saveOrUpdate(CuidadorEntity entity) {
        return cuidadorRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        cuidadorRepository.delete(this.getById(id));
    }

    @Override
    public List<CuidadorEntity> findCuidadorEntitiesByPaciente(PacienteEntity entity) {
        return cuidadorRepository.findCuidadorEntitiesByPaciente(entity);
    }

}
