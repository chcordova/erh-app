package pe.cibertec.dawi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.cibertec.dawi.model.entity.Cie10BloqueEntity;
import pe.cibertec.dawi.repository.Cie10BloqueRepository;

import java.util.List;

@Service
@Transactional
public class Cie10BloqueServiceImpl implements Cie10BloqueService {

    @Autowired
    private Cie10BloqueRepository cie10BloqueRepository;

    @Override
    public List<Cie10BloqueEntity> listAll() {
        return (List<Cie10BloqueEntity>) cie10BloqueRepository.findAll();
    }

    @Override
    public Cie10BloqueEntity getById(Long id) {
        return cie10BloqueRepository.findById(id).orElseThrow();
    }

    @Override
    public Cie10BloqueEntity saveOrUpdate(Cie10BloqueEntity entity) {
        return cie10BloqueRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        cie10BloqueRepository.delete(this.getById(id));
    }
}
