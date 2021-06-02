package pe.cibertec.dawi.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.cibertec.dawi.common.AbstractConverter;
import pe.cibertec.dawi.model.dto.UbiDepartamentoDto;
import pe.cibertec.dawi.model.entity.UbiDepartamentoEntity;
import pe.cibertec.dawi.service.UbiDepartamentoService;

@Component
public class UbiDepartamentoConverter extends AbstractConverter<UbiDepartamentoEntity, UbiDepartamentoDto> {

    @Autowired
    private UbiDepartamentoService ubiDepartamentoService;

    @Override
    protected UbiDepartamentoDto entityToDto(UbiDepartamentoEntity entity) throws Exception {
        return UbiDepartamentoDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .codigo(entity.getCodigo())
                .build();
    }

    @Override
    protected UbiDepartamentoEntity dtoToEntity(UbiDepartamentoDto dto) throws Exception {

        UbiDepartamentoEntity entity;

        if (dto.getId() == null) {
            entity = new UbiDepartamentoEntity();
        }else {
            entity = ubiDepartamentoService.getById(dto.getId());
        }

        return entity;
    }

}
