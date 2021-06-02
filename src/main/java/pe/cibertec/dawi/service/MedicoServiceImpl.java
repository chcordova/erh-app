package pe.cibertec.dawi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.cibertec.dawi.model.entity.MedicoEntity;
import pe.cibertec.dawi.repository.MedicoRepository;

import java.util.List;

@Service
@Transactional
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;


    @Override
    public List<MedicoEntity> listAll() {
        return (List<MedicoEntity>) medicoRepository.findAll();
    }

    @Override
    public MedicoEntity getById(Long id) {
        return medicoRepository.findById(id).orElseThrow();
    }

    @Override
    public MedicoEntity saveOrUpdate(MedicoEntity entity) {
        return medicoRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        medicoRepository.delete(this.getById(id));
    }

}
