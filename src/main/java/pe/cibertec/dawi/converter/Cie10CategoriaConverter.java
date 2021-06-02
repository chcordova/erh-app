package pe.cibertec.dawi.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.cibertec.dawi.common.AbstractConverter;
import pe.cibertec.dawi.model.dto.Cie10CategoriaDto;
import pe.cibertec.dawi.model.entity.Cie10CategoriaEntity;
import pe.cibertec.dawi.service.Cie10CategoriaService;

@Component
public class Cie10CategoriaConverter extends AbstractConverter<Cie10CategoriaEntity, Cie10CategoriaDto> {

    @Autowired
    private Cie10CategoriaService cie10CategoriaService;

    @Override
    protected Cie10CategoriaDto entityToDto(Cie10CategoriaEntity entity) throws Exception {
        return Cie10CategoriaDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .build();
    }

    @Override
    protected Cie10CategoriaEntity dtoToEntity(Cie10CategoriaDto dto) throws Exception {

        Cie10CategoriaEntity entity;

        if (dto.getId() == null) {
            entity = new Cie10CategoriaEntity();
        } else {
            entity = cie10CategoriaService.getById(dto.getId());
        }

        return entity;
    }

}
