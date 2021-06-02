package pe.cibertec.dawi.converter;

import org.joda.time.DateTime;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.cibertec.dawi.common.AbstractConverter;
import pe.cibertec.dawi.model.dto.PacienteDto;
import pe.cibertec.dawi.model.entity.PacienteEntity;
import pe.cibertec.dawi.model.enums.PerfilEnum;
import pe.cibertec.dawi.service.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class PacienteConverter extends AbstractConverter<PacienteEntity, PacienteDto> {

    @Autowired
    private DocumentoConverter documentoConverter;

    @Autowired
    private UbiDistritoConverter ubiDistritoConverter;
    @Autowired
    private MedicoConverter medicoConverter;
    @Autowired
    private IpressConverter ipressConverter;
    @Autowired
    private EnfermedadConverter enfermedadConverter;
    @Autowired
    private AntecedenteFamiliarConverter antecedenteFamiliarConverter;
    @Autowired
    private CuidadorConverter cuidadorConverter;
    @Autowired
    private DiscapacidadConverter discapacidadConverter;

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private DocumentoService documentoService;
    @Autowired
    private UbiDistritoService ubiDistritoService;
    @Autowired
    private MedicoService medicoService;
    @Autowired
    private IpressService ipressService;
    @Autowired
    private EnfermedadService enfermedadService;
    @Autowired
    private AntecedenteFamiliarService antecedenteFamiliarService;
    @Autowired
    private CuidadorService cuidadorService;
    @Autowired
    private DiscapacidadService discapacidadService;

    @Override
    protected PacienteDto entityToDto(PacienteEntity entity) throws Exception {
        return PacienteDto.builder()
                .id(entity.getId())

                .nombre(entity.getNombre())
                .apePaterno(entity.getApePaterno())
                .apeMaterno(entity.getApeMaterno())
                .fecNacimiento(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecNacimiento()))
                .edad(Years.yearsBetween(new DateTime(entity.getFecNacimiento()), new DateTime()).getYears())
                .documento(documentoConverter.toDto(entity.getDocumento()))
                .nroDocumento(entity.getNroDocumento())
                .genero(entity.getGenero())
                .rutaImagen(entity.getRutaImagen())
                .distritoNacimiento(ubiDistritoConverter.toDto(entity.getDistritoNacimiento()))
                .condicion(entity.getCondicion())
                .origenNacionalidad(entity.getOrigenNacionalidad())
                .origenPais(entity.getOrigenPais())
                .origenEstado(entity.getOrigenEstado())
                .origenCiudad(entity.getOrigenCiudad())
                .lugarNacimiento(entity.getLugarNacimiento())
                .email(entity.getEmail())
                .distritoResidencia(ubiDistritoConverter.toDto(entity.getDistritoResidencia()))
                .direccionActual(entity.getDireccionActual())
                .lugarProcedencia(entity.getLugarProcedencia())
                .telFijo(entity.getTelFijo())
                .telMovil(entity.getTelMovil())

                .medico(medicoConverter.toDto(entity.getMedico()))
                .ipress(ipressConverter.toDto(entity.getIpress()))
                .perfil(entity.getPerfil())

                .estado(entity.getEstado())
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecRegistro()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecModificacion()))
                .build();
    }

    @Override
    protected PacienteEntity dtoToEntity(PacienteDto dto) throws Exception {

        PacienteEntity entity;

        if (dto.getId() == null) {
            entity = new PacienteEntity();
            entity.setFecRegistro(new Date());
        }else {
            entity = pacienteService.getById(dto.getId());
        }

        entity.setId(dto.getId());

        entity.setNombre(dto.getNombre().trim());
        entity.setApePaterno(dto.getApePaterno().trim());
        entity.setApeMaterno(dto.getApeMaterno().trim());
        entity.setFecNacimiento(new SimpleDateFormat("dd-MM-yyyy").parse(dto.getFecNacimiento()));
        entity.setDocumento(documentoService.getById(dto.getDocumento().getId()));
        entity.setNroDocumento(dto.getNroDocumento());
        entity.setGenero(dto.getGenero());
        entity.setRutaImagen(dto.getRutaImagen());
        entity.setDistritoNacimiento(ubiDistritoService.getById(dto.getDistritoNacimiento().getId()));
        entity.setCondicion(dto.getCondicion());
        entity.setOrigenNacionalidad(dto.getOrigenNacionalidad());
        entity.setOrigenPais(dto.getOrigenPais());
        entity.setOrigenEstado(dto.getOrigenEstado());
        entity.setOrigenCiudad(dto.getOrigenCiudad());
        entity.setLugarNacimiento(dto.getLugarNacimiento());
        entity.setEmail(dto.getEmail());
        entity.setDistritoResidencia(ubiDistritoService.getById(dto.getDistritoResidencia().getId()));
        entity.setDireccionActual(dto.getDireccionActual());
        entity.setLugarProcedencia(dto.getLugarProcedencia());
        entity.setTelFijo(dto.getTelFijo());
        entity.setTelMovil(dto.getTelMovil());

        entity.setMedico(medicoService.getById(dto.getMedico().getId()));
        entity.setIpress(ipressService.getById(dto.getIpress().getId()));
        entity.setPerfil(PerfilEnum.PACIENTE);

        entity.setEstado(dto.getEstado());
        entity.setFecModificacion(new Date());

        return entity;
    }

}
