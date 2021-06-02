package pe.cibertec.dawi.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.cibertec.dawi.common.AbstractConverter;
import pe.cibertec.dawi.model.dto.TratamientoDto;
import pe.cibertec.dawi.model.entity.TratamientoEntity;
import pe.cibertec.dawi.service.EnfermedadService;
import pe.cibertec.dawi.service.TratamientoService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TratamientoConverter extends AbstractConverter<TratamientoEntity, TratamientoDto> {

    @Autowired
    private EnfermedadConverter enfermedadConverter;

    @Autowired
    private TratamientoService tratamientoService;
    @Autowired
    private EnfermedadService enfermedadService;

    @Override
    protected TratamientoDto entityToDto(TratamientoEntity entity) throws Exception {
        return TratamientoDto.builder()
                .id(entity.getId())
                .tratamientoFarmacologicoEspecifico(entity.getTratamientoFarmacologicoEspecifico())
                .detalleTratamientoFarmacologicoEspecifico(entity.getDetalleTratamientoFarmacologicoEspecifico())
                .tratamientoFarmacologicoNoEspecifico(entity.getTratamientoFarmacologicoNoEspecifico())
                .detalleTratamientoFarmacologicoNoEspecifico(entity.getDetalleTratamientoFarmacologicoNoEspecifico())
                .tratamientoNoFarmacologico(entity.getTratamientoNoFarmacologico())
                .detalleTratamientoNoFarmacologico(entity.getDetalleTratamientoNoFarmacologico())
                .terapiaFisica(entity.getTerapiaFisica())
                .ergoterapia(entity.getErgoterapia())
                .terapiaNutricionalEspecifica(entity.getTerapiaNutricionalEspecifica())
                .medicinaTradicional(entity.getMedicinaTradicional())
                .medicinaAlternativa(entity.getMedicinaAlternativa())
                .enfermedad(enfermedadConverter.toDto(entity.getEnfermedad()))

                .estado(entity.getEstado())
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecRegistro()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecModificacion()))
                .build();
    }

    @Override
    protected TratamientoEntity dtoToEntity(TratamientoDto dto) throws Exception {

        TratamientoEntity entity;

        if (dto.getId() == null) {
            entity = new TratamientoEntity();
            entity.setFecRegistro(new Date());
        } else {
            entity = tratamientoService.getById(dto.getId());
        }

        entity.setId(dto.getId());
        entity.setTratamientoFarmacologicoEspecifico(dto.getTratamientoFarmacologicoEspecifico());
        entity.setDetalleTratamientoFarmacologicoEspecifico(dto.getDetalleTratamientoFarmacologicoEspecifico().trim());
        entity.setTratamientoFarmacologicoNoEspecifico(dto.getTratamientoFarmacologicoNoEspecifico());
        entity.setDetalleTratamientoFarmacologicoNoEspecifico(dto.getDetalleTratamientoFarmacologicoNoEspecifico().trim());
        entity.setTratamientoNoFarmacologico(dto.getTratamientoNoFarmacologico());
        entity.setDetalleTratamientoNoFarmacologico(dto.getDetalleTratamientoNoFarmacologico().trim());
        entity.setTerapiaFisica(dto.getTerapiaFisica());
        entity.setErgoterapia(dto.getErgoterapia());
        entity.setTerapiaNutricionalEspecifica(dto.getTerapiaNutricionalEspecifica());
        entity.setMedicinaTradicional(dto.getMedicinaTradicional());
        entity.setMedicinaAlternativa(dto.getMedicinaAlternativa());
        entity.setEnfermedad(enfermedadService.getById(dto.getEnfermedad().getId()));

        entity.setEstado(dto.getEstado());
        entity.setFecModificacion(new Date());

        return entity;
    }

}
