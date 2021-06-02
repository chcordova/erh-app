package pe.cibertec.dawi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.cibertec.dawi.model.entity.AntecedenteFamiliarEntity;
import pe.cibertec.dawi.model.entity.PacienteEntity;
import pe.cibertec.dawi.repository.AntecedenteFamiliarRepository;

import java.util.List;

@Service
@Transactional
public class AntecedenteFamiliarServiceImpl implements AntecedenteFamiliarService {

    @Autowired
    private AntecedenteFamiliarRepository antecedenteFamiliarRepository;

    @Override
    public List<AntecedenteFamiliarEntity> listAll() {
        return (List<AntecedenteFamiliarEntity>) antecedenteFamiliarRepository.findAll();
    }

    @Override
    public AntecedenteFamiliarEntity getById(Long id) {
        return antecedenteFamiliarRepository.findById(id).orElseThrow();
    }

    @Override
    public AntecedenteFamiliarEntity saveOrUpdate(AntecedenteFamiliarEntity entity) {
        return antecedenteFamiliarRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        antecedenteFamiliarRepository.delete(this.getById(id));
    }

    @Override
    public List<AntecedenteFamiliarEntity> findAntecedenteFamiliarEntitiesByPaciente(PacienteEntity entity) {
        return antecedenteFamiliarRepository.findAntecedenteFamiliarEntitiesByPaciente(entity);
    }
}
