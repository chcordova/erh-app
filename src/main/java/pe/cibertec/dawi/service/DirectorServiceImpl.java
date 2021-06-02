package pe.cibertec.dawi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.cibertec.dawi.model.entity.DirectorEntity;
import pe.cibertec.dawi.repository.DirectorRepository;

import java.util.List;

@Service
@Transactional
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    public List<DirectorEntity> listAll() {
        return (List<DirectorEntity>) directorRepository.findAll();
    }

    @Override
    public DirectorEntity getById(Long id) {
        return directorRepository.findById(id).orElseThrow();
    }

    @Override
    public DirectorEntity saveOrUpdate(DirectorEntity entity) {
        return directorRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        directorRepository.delete(this.getById(id));
    }

}
