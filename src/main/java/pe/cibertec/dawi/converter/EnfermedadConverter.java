package pe.cibertec.dawi.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.cibertec.dawi.common.AbstractConverter;
import pe.cibertec.dawi.model.dto.EnfermedadDto;
import pe.cibertec.dawi.model.entity.EnfermedadEntity;
import pe.cibertec.dawi.service.Cie10CarpetaService;
import pe.cibertec.dawi.service.EnfermedadService;
import pe.cibertec.dawi.service.MedicoService;
import pe.cibertec.dawi.service.OrphanetService;
import pe.cibertec.dawi.service.PacienteService;
import pe.cibertec.dawi.service.TratamientoService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class EnfermedadConverter extends AbstractConverter<EnfermedadEntity, EnfermedadDto> {

    @Autowired
    private PacienteConverter pacienteConverter;
    @Autowired
    private MedicoConverter medicoConverter;
    @Autowired
    private Cie10CarpetaConverter cie10CarpetaConverter;
    @Autowired
    private OrphanetConverter orphanetConverter;
    @Autowired
    private TratamientoConverter tratamientoConverter;

    @Autowired
    private EnfermedadService enfermedadService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private MedicoService medicoService;
    @Autowired
    private Cie10CarpetaService cie10CarpetaService;
    @Autowired
    private OrphanetService orphanetService;
    @Autowired
    private TratamientoService tratamientoService;

    @Override
    protected EnfermedadDto entityToDto(EnfermedadEntity entity) throws Exception {

        return EnfermedadDto.builder()
                .id(entity.getId())
                .detalleDiagnostico(entity.getDetalleDiagnostico())
                .detalleExamenesAuxiliares(entity.getDetalleExamenesAuxiliares())
                .paciente(pacienteConverter.toDto(entity.getPaciente()))
                .cie10Carpeta(cie10CarpetaConverter.toDto(entity.getCie10Carpeta()))
                .orphanet(orphanetConverter.toDto(entity.getOrphanet()))
                .consentimientoInformado(entity.getConsentimientoInformado())
                .diagnosticoClinico(entity.getDiagnosticoClinico())
                .diagnosticoPorGenetico(entity.getDiagnosticoPorGenetico())
                .diagnosticoBioquimico(entity.getDiagnosticoBioquimico())
                .diagnosticoPorImagenes(entity.getDiagnosticoPorImagenes())
                .diagnosticoInmunologico(entity.getDiagnosticoInmunologico())

                .estado(entity.getEstado())
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecRegistro()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecModificacion()))
                .build();
    }

    @Override
    protected EnfermedadEntity dtoToEntity(EnfermedadDto dto) throws Exception {

        EnfermedadEntity entity;

        if (dto.getId() == null) {
            entity = new EnfermedadEntity();
            entity.setFecRegistro(new Date());
        } else {
            entity = enfermedadService.getById(dto.getId());
        }

        entity.setId(dto.getId());
        entity.setDetalleDiagnostico(dto.getDetalleDiagnostico().trim());
        entity.setDetalleExamenesAuxiliares(dto.getDetalleExamenesAuxiliares().trim());
        entity.setPaciente(pacienteService.getById(dto.getPaciente().getId()));
        entity.setCie10Carpeta(cie10CarpetaService.getById(dto.getCie10Carpeta().getId()));
        entity.setOrphanet(orphanetService.getById(dto.getOrphanet().getId()));
        entity.setConsentimientoInformado(dto.getConsentimientoInformado());
        entity.setDiagnosticoClinico(dto.getDiagnosticoClinico());
        entity.setDiagnosticoPorGenetico(dto.getDiagnosticoPorGenetico());
        entity.setDiagnosticoBioquimico(dto.getDiagnosticoBioquimico());
        entity.setDiagnosticoPorImagenes(dto.getDiagnosticoPorImagenes());
        entity.setDiagnosticoInmunologico(dto.getDiagnosticoInmunologico());

        entity.setEstado(dto.getEstado());
        entity.setFecModificacion(new Date());

        return entity;
    }

}
