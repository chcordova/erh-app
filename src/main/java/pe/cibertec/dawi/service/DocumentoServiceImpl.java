package pe.cibertec.dawi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.cibertec.dawi.model.entity.DocumentoEntity;
import pe.cibertec.dawi.repository.DocumentoRepository;

import java.util.List;

@Service
@Transactional
public class DocumentoServiceImpl implements DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;


    @Override
    public List<DocumentoEntity> listAll() {
        return (List<DocumentoEntity>) documentoRepository.findAll();
    }

    @Override
    public DocumentoEntity getById(Long id) {
        return documentoRepository.findById(id).orElseThrow();
    }

    @Override
    public DocumentoEntity saveOrUpdate(DocumentoEntity entity) {
        return documentoRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        documentoRepository.delete(this.getById(id));
    }

}
