package pe.cibertec.dawi.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.cibertec.dawi.common.AbstractConverter;
import pe.cibertec.dawi.model.dto.MedicoDto;
import pe.cibertec.dawi.model.entity.MedicoEntity;
import pe.cibertec.dawi.model.enums.PerfilEnum;
import pe.cibertec.dawi.service.DocumentoService;
import pe.cibertec.dawi.service.IpressService;
import pe.cibertec.dawi.service.MedicoService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MedicoConverter extends AbstractConverter<MedicoEntity, MedicoDto> {

    @Autowired
    private DocumentoConverter documentoConverter;
//    @Autowired
//    private UbiDistritoConverter ubiDistritoConverter;
    @Autowired
    private IpressConverter ipressConverter;

    @Autowired
    private MedicoService medicoService;
    @Autowired
    private DocumentoService documentoService;
//    @Autowired
//    private UbiDistritoService ubiDistritoService;
    @Autowired
    private IpressService ipressService;

    @Override
    protected MedicoDto entityToDto(MedicoEntity entity) throws Exception {

        return MedicoDto.builder()
                .id(entity.getId())

                .nombre(entity.getNombre())
                .apePaterno(entity.getApePaterno())
                .apeMaterno(entity.getApeMaterno())
//                .fecNacimiento(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecNacimiento()))
//                .edad(Years.yearsBetween(new DateTime(entity.getFecNacimiento()), new DateTime()).getYears())
                .documento(documentoConverter.toDto(entity.getDocumento()))
                .nroDocumento(entity.getNroDocumento())
//                .genero(entity.getGenero())
                .rutaImagen(entity.getRutaImagen())
//                .distritoNacimiento(ubiDistritoConverter.toDto(entity.getDistritoNacimiento()))
//                .condicion(entity.getCondicion())
//                .origenNacionalidad(entity.getOrigenNacionalidad())
//                .origenPais(entity.getOrigenPais())
//                .origenEstado(entity.getOrigenEstado())
//                .origenCiudad(entity.getOrigenCiudad())
//                .lugarNacimiento(entity.getLugarNacimiento())
//                .email(entity.getEmail())
//                .distritoResidencia(ubiDistritoConverter.toDto(entity.getDistritoResidencia()))
//                .direccionActual(entity.getDireccionActual())
//                .lugarProcedencia(entity.getLugarProcedencia())
//                .telFijo(entity.getTelFijo())
//                .telMovil(entity.getTelMovil())

                .cmp(entity.getCmp())
                .rne(entity.getRne())
                .especialidad(entity.getEspecialidad())
                .ipress(ipressConverter.toDto(entity.getIpress()))
                .perfil(entity.getPerfil())

                .estado(entity.getEstado())
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecRegistro()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecModificacion()))
                .build();
    }

    @Override
    protected MedicoEntity dtoToEntity(MedicoDto dto) throws Exception {

        MedicoEntity entity;

        if (dto.getId() == null) {
            entity = new MedicoEntity();
            entity.setFecRegistro(new Date());
        } else {
            entity = medicoService.getById(dto.getId());
        }

        entity.setId(dto.getId());

        entity.setNombre(dto.getNombre().trim());
        entity.setApePaterno(dto.getApePaterno().trim());
        entity.setApeMaterno(dto.getApeMaterno().trim());
//        entity.setFecNacimiento(new SimpleDateFormat("dd-MM-yyyy").parse(dto.getFecNacimiento()));
        entity.setDocumento(documentoService.getById(dto.getDocumento().getId()));
        entity.setNroDocumento(dto.getNroDocumento());
//        entity.setGenero(dto.getGenero());
        entity.setRutaImagen(dto.getRutaImagen());
//        entity.setDistritoNacimiento(ubiDistritoService.getById(dto.getDistritoNacimiento().getId()));
//        entity.setCondicion(dto.getCondicion());
//        entity.setOrigenNacionalidad(dto.getOrigenNacionalidad());
//        entity.setOrigenPais(dto.getOrigenPais());
//        entity.setOrigenEstado(dto.getOrigenEstado());
//        entity.setOrigenCiudad(dto.getOrigenCiudad());
//        entity.setLugarNacimiento(dto.getLugarNacimiento());
//        entity.setEmail(dto.getEmail());
//        entity.setDistritoResidencia(ubiDistritoService.getById(dto.getDistritoResidencia().getId()));
//        entity.setDireccionActual(dto.getDireccionActual());
//        entity.setLugarProcedencia(dto.getLugarProcedencia());
//        entity.setTelFijo(dto.getTelFijo());
//        entity.setTelMovil(dto.getTelMovil());

        entity.setCmp(dto.getCmp().trim());
        entity.setRne(dto.getRne().trim());
        entity.setEspecialidad(dto.getEspecialidad().trim());
        entity.setIpress(ipressService.getById(dto.getIpress().getId()));
        entity.setPerfil(PerfilEnum.DIRECTOR);

        entity.setEstado(dto.getEstado());
        entity.setFecModificacion(new Date());

        return entity;
    }

}
