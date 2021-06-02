package pe.cibertec.dawi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.cibertec.dawi.model.entity.EnlaceInteresEntity;
import pe.cibertec.dawi.repository.EnlaceInteresRepository;

import java.util.List;

@Service
@Transactional
public class EnlaceInteresServiceImpl implements EnlaceInteresService {

    @Autowired
    private EnlaceInteresRepository enlaceInteresRepository;

    @Override
    public List<EnlaceInteresEntity> listAll() {
        return (List<EnlaceInteresEntity>) enlaceInteresRepository.findAll();
    }

    @Override
    public EnlaceInteresEntity getById(Long id) {
        return enlaceInteresRepository.findById(id).orElseThrow();
    }

    @Override
    public EnlaceInteresEntity saveOrUpdate(EnlaceInteresEntity entity) {
        return enlaceInteresRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        enlaceInteresRepository.delete(this.getById(id));
    }

}
