package pe.cibertec.dawi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.cibertec.dawi.converter.EnfermedadConverter;
import pe.cibertec.dawi.converter.TratamientoConverter;
import pe.cibertec.dawi.model.dto.EnfermedadDto;
import pe.cibertec.dawi.model.dto.TratamientoDto;
import pe.cibertec.dawi.model.entity.TratamientoEntity;
import pe.cibertec.dawi.model.enums.EstadoEnum;
import pe.cibertec.dawi.service.EnfermedadService;
import pe.cibertec.dawi.service.TratamientoService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@Secured({"ROLE_MASTER", "ROLE_DIRECTOR", "ROLE_MEDICO", "ROLE_PACIENTE"})
@RequestMapping("/tratamiento")
public class TratamientoController {

    @Autowired
    private TratamientoService tratamientoService;
    @Autowired
    private TratamientoConverter tratamientoConverter;

    @Autowired
    private EnfermedadService enfermedadService;
    @Autowired
    private EnfermedadConverter enfermedadConverter;

    @RequestMapping(value = "/mostrar/{id}", method = RequestMethod.GET)
    public String mostrar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Tratamiento");
        model.addAttribute("opcion", "Mostrar");
        model.addAttribute("tratamiento", tratamientoConverter.toDto(tratamientoService.getById(id)));
        return "tratamiento/mostrar";
    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Tratamiento");
        model.addAttribute("opcion", "Editar");

        model.addAttribute("tratamiento", tratamientoConverter.toDto(tratamientoService.getById(id)));

        return "tratamiento/formulario";
    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(value = "/nuevo", method = RequestMethod.GET)
    public String nuevo(@RequestParam(value = "enfermedadId", required = false) Long enfermedadId, Model model) throws Exception {
        model.addAttribute("titulo", "Tratamiento");
        model.addAttribute("opcion", "Nuevo");

        EnfermedadDto enfermedadDto = enfermedadConverter.toDto(enfermedadService.getById(enfermedadId));

        model.addAttribute("tratamiento", TratamientoDto.builder()
                .tratamientoFarmacologicoEspecifico(EstadoEnum.INACTIVO)
                .tratamientoFarmacologicoNoEspecifico(EstadoEnum.INACTIVO)
                .tratamientoNoFarmacologico(EstadoEnum.INACTIVO)
                .terapiaFisica(EstadoEnum.INACTIVO)
                .ergoterapia(EstadoEnum.INACTIVO)
                .terapiaNutricionalEspecifica(EstadoEnum.INACTIVO)
                .medicinaTradicional(EstadoEnum.INACTIVO)
                .medicinaAlternativa(EstadoEnum.INACTIVO)

                .enfermedad(enfermedadDto)
                .estado(EstadoEnum.ACTIVO)
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .build());



        return "tratamiento/formulario";
    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(TratamientoDto dto, Model model) throws Exception {

        List<TratamientoDto> entities = new ArrayList<>();
        TratamientoEntity newEntity = tratamientoService.saveOrUpdate(tratamientoConverter.toEntity(dto));

        if(newEntity != null){
            entities.addAll(tratamientoConverter.toListDto(tratamientoService.findTratamientoEntitiesByEnfermedad(newEntity.getEnfermedad())));
        }

        if (entities.size() > 0) {
            model.addAttribute("enfermedad", tratamientoConverter.toDto(newEntity).getEnfermedad());
            model.addAttribute("tratamientos", entities);
            model.addAttribute("success", "El registro de tratamiento se realizó con éxito.");
        } else {
            model.addAttribute("warning", "Ocurrió un error al registrar el tratamiento.");
        }

        model.addAttribute("titulo", "Tratamiento");
        model.addAttribute("opcion", "Búsqueda");

        return "tratamiento/listar";

    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(value = "/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id) throws Exception {

        TratamientoEntity entity = tratamientoService.getById(id);
        tratamientoService.delete(id);

        return String.format("redirect:/enfermedad/%s/tratamiento", tratamientoConverter.toDto(entity).getEnfermedad().getId());
    }

}
