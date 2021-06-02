package pe.cibertec.dawi.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.cibertec.dawi.common.AbstractConverter;
import pe.cibertec.dawi.model.dto.OrphanetDto;
import pe.cibertec.dawi.model.entity.OrphanetEntity;
import pe.cibertec.dawi.service.OrphanetService;

@Component
public class OrphanetConverter extends AbstractConverter<OrphanetEntity, OrphanetDto> {

    @Autowired
    private OrphanetService orphanetService;

    @Override
    protected OrphanetDto entityToDto(OrphanetEntity entity) throws Exception {
        return OrphanetDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .codigo(entity.getCodigo())
                .build();
    }

    @Override
    protected OrphanetEntity dtoToEntity(OrphanetDto dto) throws Exception {

        OrphanetEntity entity;

        if (dto.getId() == null) {
            entity = new OrphanetEntity();
        } else {
            entity = orphanetService.getById(dto.getId());
        }

        return entity;
    }

}
