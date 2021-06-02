package pe.cibertec.dawi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.cibertec.dawi.model.entity.Cie10CategoriaEntity;
import pe.cibertec.dawi.model.entity.UbiDepartamentoEntity;
import pe.cibertec.dawi.repository.Cie10CategoriaRepository;
import pe.cibertec.dawi.repository.UbiDepartamentoRepository;

import java.util.List;

@Service
@Transactional
public class Cie10CategoriaServiceImpl implements Cie10CategoriaService {

    @Autowired
    private Cie10CategoriaRepository cie10CategoriaRepository;

    @Override
    public List<Cie10CategoriaEntity> listAll() {
        return (List<Cie10CategoriaEntity>) cie10CategoriaRepository.findAll();
    }

    @Override
    public Cie10CategoriaEntity getById(Long id) {
        return cie10CategoriaRepository.findById(id).orElseThrow();
    }

    @Override
    public Cie10CategoriaEntity saveOrUpdate(Cie10CategoriaEntity entity) {
        return cie10CategoriaRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        cie10CategoriaRepository.delete(this.getById(id));
    }
}
