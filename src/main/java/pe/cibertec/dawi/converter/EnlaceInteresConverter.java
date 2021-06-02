package pe.cibertec.dawi.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.cibertec.dawi.common.AbstractConverter;
import pe.cibertec.dawi.model.dto.EnlaceInteresDto;
import pe.cibertec.dawi.model.entity.EnlaceInteresEntity;
import pe.cibertec.dawi.service.EnlaceInteresService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class EnlaceInteresConverter extends AbstractConverter<EnlaceInteresEntity, EnlaceInteresDto> {

    @Autowired
    private EnlaceInteresService enlaceInteresService;

    @Override
    protected EnlaceInteresDto entityToDto(EnlaceInteresEntity entity) throws Exception {
        return EnlaceInteresDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .url(entity.getUrl())
                .dirigido(entity.getDirigido())
                .direccion(entity.getDireccion())
                .telefono(entity.getTelefono())
                .email(entity.getEmail())

                .estado(entity.getEstado())
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecRegistro()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecModificacion()))
                .build();
    }

    @Override
    protected EnlaceInteresEntity dtoToEntity(EnlaceInteresDto dto) throws Exception {

        EnlaceInteresEntity entity;
        if (dto.getId() == null) {
            entity = new EnlaceInteresEntity();
            entity.setFecRegistro(new Date());
        } else {
            entity = enlaceInteresService.getById(dto.getId());
        }
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre().trim());
        entity.setUrl(dto.getUrl());
        entity.setDirigido(dto.getDirigido());
        entity.setDireccion(dto.getDireccion());
        entity.setTelefono(dto.getTelefono());
        entity.setEmail(dto.getEmail());

        entity.setEstado(dto.getEstado());
        entity.setFecModificacion(new Date());

        return entity;

    }
}
