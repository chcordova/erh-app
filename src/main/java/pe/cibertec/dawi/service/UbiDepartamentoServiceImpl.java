package pe.cibertec.dawi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.cibertec.dawi.model.entity.UbiDepartamentoEntity;
import pe.cibertec.dawi.repository.UbiDepartamentoRepository;

import java.util.List;

@Service
@Transactional
public class UbiDepartamentoServiceImpl implements UbiDepartamentoService {

    @Autowired
    private UbiDepartamentoRepository ubiDepartamentoRepository;


    @Override
    public List<UbiDepartamentoEntity> listAll() {
        return (List<UbiDepartamentoEntity>) ubiDepartamentoRepository.findAll();
    }

    @Override
    public UbiDepartamentoEntity getById(Long id) {
        return ubiDepartamentoRepository.findById(id).orElseThrow();
    }

    @Override
    public UbiDepartamentoEntity saveOrUpdate(UbiDepartamentoEntity entity) {
        return ubiDepartamentoRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        ubiDepartamentoRepository.delete(this.getById(id));
    }
}
