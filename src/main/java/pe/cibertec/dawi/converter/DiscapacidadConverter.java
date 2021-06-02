package pe.cibertec.dawi.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.cibertec.dawi.common.AbstractConverter;
import pe.cibertec.dawi.model.dto.DiscapacidadDto;
import pe.cibertec.dawi.model.entity.DiscapacidadEntity;
import pe.cibertec.dawi.service.DiscapacidadService;
import pe.cibertec.dawi.service.PacienteService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DiscapacidadConverter extends AbstractConverter<DiscapacidadEntity, DiscapacidadDto> {

    @Autowired
    private  PacienteConverter pacienteConverter;

    @Autowired
    private DiscapacidadService discapacidadService;
    @Autowired
    private PacienteService pacienteService;

    @Override
    protected DiscapacidadDto entityToDto(DiscapacidadEntity entity) throws Exception {

        return DiscapacidadDto.builder()
                .id(entity.getId())
                .limitacionFuncional(entity.getLimitacionFuncional())
                .detallelimitacionfuncional(entity.getDetallelimitacionfuncional())
                .inscritoConadis(entity.getInscritoConadis())
                .detalleObservaciones(entity.getDetalleObservaciones())
                .paciente(pacienteConverter.toDto(entity.getPaciente()))

                .estado(entity.getEstado())
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecRegistro()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecModificacion()))
                .build();
    }

    @Override
    protected DiscapacidadEntity dtoToEntity(DiscapacidadDto dto) throws Exception {

        DiscapacidadEntity entity;

        if (dto.getId() == null) {
            entity = new DiscapacidadEntity();
            entity.setFecRegistro(new Date());
        } else {
            entity = discapacidadService.getById(dto.getId());
        }

        entity.setId(dto.getId());
        entity.setLimitacionFuncional(dto.getLimitacionFuncional());
        entity.setDetallelimitacionfuncional(dto.getDetallelimitacionfuncional().trim());
        entity.setInscritoConadis(dto.getInscritoConadis());
        entity.setDetalleObservaciones(dto.getDetalleObservaciones().trim());
        entity.setPaciente(pacienteService.getById(dto.getPaciente().getId()));

        entity.setEstado(dto.getEstado());
        entity.setFecModificacion(new Date());

        return entity;
    }

}
