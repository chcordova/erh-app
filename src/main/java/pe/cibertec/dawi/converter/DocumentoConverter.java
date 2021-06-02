package pe.cibertec.dawi.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.cibertec.dawi.common.AbstractConverter;
import pe.cibertec.dawi.model.dto.DocumentoDto;
import pe.cibertec.dawi.model.entity.DocumentoEntity;
import pe.cibertec.dawi.service.DocumentoService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DocumentoConverter extends AbstractConverter<DocumentoEntity, DocumentoDto> {

    @Autowired
    private DocumentoService documentoService;

    @Override
    protected DocumentoDto entityToDto(DocumentoEntity entity) throws Exception {
        return DocumentoDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())

                .estado(entity.getEstado())
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecRegistro()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecModificacion()))
                .build();
    }

    @Override
    protected DocumentoEntity dtoToEntity(DocumentoDto dto) throws Exception {

        DocumentoEntity entity;

        if (dto.getId() == null) {
            entity = new DocumentoEntity();
            entity.setFecRegistro(new Date());
        } else {
            entity = documentoService.getById(dto.getId());
        }

        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre().trim());

        entity.setEstado(dto.getEstado());
        entity.setFecModificacion(new Date());

        return entity;
    }

}
