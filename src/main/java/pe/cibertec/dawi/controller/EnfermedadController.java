package pe.cibertec.dawi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.cibertec.dawi.converter.Cie10CarpetaConverter;
import pe.cibertec.dawi.converter.EnfermedadConverter;
import pe.cibertec.dawi.converter.OrphanetConverter;
import pe.cibertec.dawi.converter.PacienteConverter;
import pe.cibertec.dawi.converter.TratamientoConverter;
import pe.cibertec.dawi.model.dto.EnfermedadDto;
import pe.cibertec.dawi.model.dto.PacienteDto;
import pe.cibertec.dawi.model.entity.EnfermedadEntity;
import pe.cibertec.dawi.model.enums.EstadoEnum;
import pe.cibertec.dawi.service.Cie10CarpetaService;
import pe.cibertec.dawi.service.EnfermedadService;
import pe.cibertec.dawi.service.OrphanetService;
import pe.cibertec.dawi.service.PacienteService;
import pe.cibertec.dawi.service.TratamientoService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Secured({"ROLE_MASTER", "ROLE_DIRECTOR", "ROLE_MEDICO", "ROLE_PACIENTE"})
@RequestMapping("/enfermedad")
public class EnfermedadController {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private PacienteConverter pacienteConverter;

    @Autowired
    private EnfermedadService enfermedadService;
    @Autowired
    private EnfermedadConverter enfermedadConverter;

    @Autowired
    private TratamientoService tratamientoService;
    @Autowired
    private TratamientoConverter tratamientoConverter;

    @Autowired
    private Cie10CarpetaService cie10CarpetaService;

    @Autowired
    private Cie10CarpetaConverter cie10CarpetaConverter;

    @Autowired
    private OrphanetService orphanetService;

    @Autowired
    private OrphanetConverter orphanetConverter;

    @RequestMapping(value = "/mostrar/{id}", method = RequestMethod.GET)
    public String mostrar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Enfermedad");
        model.addAttribute("opcion", "Mostrar");

        model.addAttribute("enfermedad", enfermedadConverter.toDto(enfermedadService.getById(id)));

        return "enfermedad/mostrar";
    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Enfermedad");
        model.addAttribute("opcion", "Editar");

        model.addAttribute("enfermedad", enfermedadConverter.toDto(enfermedadService.getById(id)));

        model.addAttribute("cie10Carpetas", cie10CarpetaConverter.toListDto(cie10CarpetaService.listAll()));
        model.addAttribute("orphanets", orphanetConverter.toListDto(orphanetService.listAll()));

        return "enfermedad/formulario";
    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(value = "/nuevo", method = RequestMethod.GET)
    public String nuevo(@RequestParam(value = "pacienteId", required = false) Long pacienteId, Model model) throws Exception {
        model.addAttribute("titulo", "Enfermedad");
        model.addAttribute("opcion", "Nuevo");

        PacienteDto pacienteDto = pacienteConverter.toDto(pacienteService.getById(pacienteId));

        model.addAttribute("enfermedad", EnfermedadDto.builder()
                .consentimientoInformado(EstadoEnum.INACTIVO)
                .diagnosticoClinico(EstadoEnum.INACTIVO)
                .diagnosticoPorGenetico(EstadoEnum.INACTIVO)
                .diagnosticoBioquimico(EstadoEnum.INACTIVO)
                .diagnosticoPorImagenes(EstadoEnum.INACTIVO)
                .diagnosticoInmunologico(EstadoEnum.INACTIVO)
                .paciente(pacienteDto)
                .estado(EstadoEnum.ACTIVO)
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .build());

        model.addAttribute("cie10Carpetas", cie10CarpetaConverter.toListDto(cie10CarpetaService.listAll()));
        model.addAttribute("orphanets", orphanetConverter.toListDto(orphanetService.listAll()));

        return "enfermedad/formulario";
    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(EnfermedadDto dto, Model model) throws Exception {
        model.addAttribute("titulo", "Enfermedad");
        model.addAttribute("opcion", "Búsqueda");

        EnfermedadEntity newEntity = enfermedadService.saveOrUpdate(enfermedadConverter.toEntity(dto));

        if (newEntity != null) {
            model.addAttribute("paciente", enfermedadConverter.toDto(newEntity).getPaciente());
            model.addAttribute("enfermedades", enfermedadConverter.toListDto(enfermedadService.findEnfermedadEntitiesByPaciente(newEntity.getPaciente())));
            model.addAttribute("success", "El registro de enfermedad se realizó con éxito.");
        } else {
            model.addAttribute("warning", "Ocurrió un error al registrar la enfermedad.");
        }

        return "enfermedad/listar";

    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(value = "/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id) throws Exception {

        EnfermedadEntity entity = enfermedadService.getById(id);
        enfermedadService.delete(id);

        return String.format("redirect:/paciente/%s/enfermedad", enfermedadConverter.toDto(entity).getPaciente().getId());
    }

    @RequestMapping(value = "/{enfermedadId}/tratamiento", method = RequestMethod.GET)
    public String listarTratamiento(@PathVariable(value = "enfermedadId") Long enfermedadId, Model model) throws Exception {
        model.addAttribute("titulo", "Tratamiento");
        model.addAttribute("opcion", "Búsqueda");

        EnfermedadEntity entity = enfermedadService.getById(enfermedadId);
        model.addAttribute("enfermedad", enfermedadConverter.toDto(entity));
        model.addAttribute("tratamientos", tratamientoConverter.toListDto(tratamientoService.findTratamientoEntitiesByEnfermedad(entity)));
        return "tratamiento/listar";
    }

}
