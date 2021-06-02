package pe.cibertec.dawi.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.cibertec.dawi.common.AbstractConverter;
import pe.cibertec.dawi.model.dto.Cie10BloqueDto;
import pe.cibertec.dawi.model.entity.Cie10BloqueEntity;
import pe.cibertec.dawi.service.Cie10BloqueService;

@Component
public class Cie10BloqueConverter extends AbstractConverter<Cie10BloqueEntity, Cie10BloqueDto> {

    @Autowired
    private Cie10BloqueService cie10BloqueService;

    @Autowired
    private Cie10CategoriaConverter cie10CategoriaConverter;

    @Override
    protected Cie10BloqueDto entityToDto(Cie10BloqueEntity entity) throws Exception {
        return Cie10BloqueDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .codigo(entity.getCodigo())
                .cie10Categoria(cie10CategoriaConverter.toDto(entity.getCie10Categoria()))
                .build();
    }

    @Override
    protected Cie10BloqueEntity dtoToEntity(Cie10BloqueDto dto) throws Exception {

        Cie10BloqueEntity entity;

        if (dto.getId() == null) {
            entity = new Cie10BloqueEntity();
        } else {
            entity = cie10BloqueService.getById(dto.getId());
        }

        return entity;
    }

}
