package pe.cibertec.dawi.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.cibertec.dawi.common.AbstractConverter;
import pe.cibertec.dawi.model.dto.ParentescoDto;
import pe.cibertec.dawi.model.entity.ParentescoEntity;
import pe.cibertec.dawi.service.ParentescoService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ParentescoConverter extends AbstractConverter<ParentescoEntity, ParentescoDto> {

    @Autowired
    private ParentescoService parentescoService;

    @Override
    protected ParentescoDto entityToDto(ParentescoEntity entity) throws Exception {
        return ParentescoDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())

                .estado(entity.getEstado())
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecRegistro()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecModificacion()))
                .build();
    }

    @Override
    protected ParentescoEntity dtoToEntity(ParentescoDto dto) throws Exception {

        ParentescoEntity entity;

        if (dto.getId() == null) {
            entity = new ParentescoEntity();
            entity.setFecRegistro(new Date());
        } else {
            entity = parentescoService.getById(dto.getId());
        }

        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre().trim());

        entity.setEstado(dto.getEstado());
        entity.setFecModificacion(new Date());

        return entity;
    }

}
