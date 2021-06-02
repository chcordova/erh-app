package pe.cibertec.dawi.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.cibertec.dawi.common.AbstractConverter;
import pe.cibertec.dawi.model.dto.IpressDto;
import pe.cibertec.dawi.model.entity.IpressEntity;
import pe.cibertec.dawi.service.IpressService;

import java.text.SimpleDateFormat;

@Component
public class IpressConverter extends AbstractConverter<IpressEntity, IpressDto> {

    @Autowired
    private UbiDistritoConverter ubiDistritoConverter;

    @Autowired
    private IpressService ipressService;

    @Override
    protected IpressDto entityToDto(IpressEntity entity) throws Exception {
        return IpressDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .codigo(entity.getCodigo())
                .direccion(entity.getDireccion())
                .distrito(ubiDistritoConverter.toDto(entity.getDistrito()))
                .telefono(entity.getTelefono())
                .ruc(entity.getRuc())

                .estado(entity.getEstado())
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecRegistro()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecModificacion()))
                .build();
    }

    @Override
    protected IpressEntity dtoToEntity(IpressDto dto) throws Exception {

        IpressEntity entity;
        if (dto.getId() == null) {
            entity = new IpressEntity();
        } else {
            entity = ipressService.getById(dto.getId());
        }
        return entity;
    }
}
