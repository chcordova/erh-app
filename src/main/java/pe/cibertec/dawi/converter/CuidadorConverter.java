package pe.cibertec.dawi.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.cibertec.dawi.common.AbstractConverter;
import pe.cibertec.dawi.model.dto.CuidadorDto;
import pe.cibertec.dawi.model.entity.CuidadorEntity;
import pe.cibertec.dawi.model.enums.PerfilEnum;
import pe.cibertec.dawi.service.CuidadorService;
import pe.cibertec.dawi.service.DocumentoService;
import pe.cibertec.dawi.service.PacienteService;
import pe.cibertec.dawi.service.ParentescoService;
import pe.cibertec.dawi.service.UbiDistritoService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CuidadorConverter extends AbstractConverter<CuidadorEntity, CuidadorDto> {

    @Autowired
    private PacienteConverter pacienteConverter;
    @Autowired
    private DocumentoConverter documentoConverter;
    @Autowired
    private UbiDistritoConverter ubiDistritoConverter;
    @Autowired
    private ParentescoConverter parentescoConverter;

    @Autowired
    private PacienteService pacienteService;
//    @Autowired
//    private IpressConverter ipressConverter;
    @Autowired
    private CuidadorService cuidadorService;
    @Autowired
    private DocumentoService documentoService;
    @Autowired
    private UbiDistritoService ubiDistritoService;
    @Autowired
    private ParentescoService parentescoService;
//    @Autowired
//    private IpressService ipressService;

    @Override
    protected CuidadorDto entityToDto(CuidadorEntity entity) throws Exception {

        return CuidadorDto.builder()
                .id(entity.getId())

                .nombre(entity.getNombre())
                .apePaterno(entity.getApePaterno())
                .apeMaterno(entity.getApeMaterno())
//                .fecNacimiento(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecNacimiento()))
//                .edad(Years.yearsBetween(new DateTime(entity.getFecNacimiento()), new DateTime()).getYears())
                .documento(documentoConverter.toDto(entity.getDocumento()))
                .nroDocumento(entity.getNroDocumento())
                .genero(entity.getGenero())
                .rutaImagen(entity.getRutaImagen())
//                .distritoNacimiento(ubiDistritoConverter.toDto(entity.getDistritoNacimiento()))
//                .condicion(entity.getCondicion())
//                .origenNacionalidad(entity.getOrigenNacionalidad())
//                .origenPais(entity.getOrigenPais())
//                .origenEstado(entity.getOrigenEstado())
//                .origenCiudad(entity.getOrigenCiudad())
//                .lugarNacimiento(entity.getLugarNacimiento())
                .distritoResidencia(ubiDistritoConverter.toDto(entity.getDistritoResidencia()))
                .direccionActual(entity.getDireccionActual())
//                .lugarProcedencia(entity.getLugarProcedencia())
                .email(entity.getEmail())
                .telFijo(entity.getTelFijo())
                .telMovil(entity.getTelMovil())

                .parentesco(parentescoConverter.toDto(entity.getParentesco()))
                .detalleParentescoNinguno(entity.getDetalleParentescoNinguno())
                .laboraActualmente(entity.getLaboraActualmente())
                .detalleLugarDeTrabajo(entity.getDetalleLugarDeTrabajo())
//                .ipress(ipressConverter.toDto(entity.getIpress()))
                .perfil(entity.getPerfil())

                .paciente(pacienteConverter.toDto(entity.getPaciente()))

                .estado(entity.getEstado())
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecRegistro()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecModificacion()))
                .build();
    }

    @Override
    protected CuidadorEntity dtoToEntity(CuidadorDto dto) throws Exception {

        CuidadorEntity entity;

        if (dto.getId() == null) {
            entity = new CuidadorEntity();
            entity.setFecRegistro(new Date());
        } else {
            entity = cuidadorService.getById(dto.getId());
        }

        entity.setId(dto.getId());

        entity.setNombre(dto.getNombre().trim());
        entity.setApePaterno(dto.getApePaterno().trim());
        entity.setApeMaterno(dto.getApeMaterno().trim());
//        entity.setFecNacimiento(new SimpleDateFormat("dd-MM-yyyy").parse(dto.getFecNacimiento()));
        entity.setDocumento(documentoService.getById(dto.getDocumento().getId()));
        entity.setNroDocumento(dto.getNroDocumento());
        entity.setGenero(dto.getGenero());
        entity.setRutaImagen(dto.getRutaImagen());
//        entity.setDistritoNacimiento(ubiDistritoService.getById(dto.getDistritoNacimiento().getId()));
//        entity.setCondicion(dto.getCondicion());
//        entity.setOrigenNacionalidad(dto.getOrigenNacionalidad());
//        entity.setOrigenPais(dto.getOrigenPais());
//        entity.setOrigenEstado(dto.getOrigenEstado());
//        entity.setOrigenCiudad(dto.getOrigenCiudad());
//        entity.setLugarNacimiento(dto.getLugarNacimiento());
        entity.setDistritoResidencia(ubiDistritoService.getById(dto.getDistritoResidencia().getId()));
        entity.setDireccionActual(dto.getDireccionActual());
//        entity.setLugarProcedencia(dto.getLugarProcedencia());
        entity.setEmail(dto.getEmail());
        entity.setTelFijo(dto.getTelFijo());
        entity.setTelMovil(dto.getTelMovil());

        entity.setParentesco(parentescoService.getById(dto.getParentesco().getId()));
        entity.setDetalleParentescoNinguno(dto.getDetalleParentescoNinguno().trim());
        entity.setLaboraActualmente(dto.getLaboraActualmente());
        entity.setDetalleLugarDeTrabajo(dto.getDetalleLugarDeTrabajo().trim());
//        entity.setIpress(ipressService.getById(dto.getIpress().getId()));
        entity.setPerfil(PerfilEnum.CUIDADOR);

        entity.setPaciente(pacienteService.getById(dto.getPaciente().getId()));

        entity.setEstado(dto.getEstado());
        entity.setFecModificacion(new Date());

        return entity;
    }

}
