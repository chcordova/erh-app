package pe.cibertec.dawi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.cibertec.dawi.converter.CuidadorConverter;
import pe.cibertec.dawi.converter.DocumentoConverter;
import pe.cibertec.dawi.converter.PacienteConverter;
import pe.cibertec.dawi.converter.ParentescoConverter;
import pe.cibertec.dawi.converter.UbiDistritoConverter;
import pe.cibertec.dawi.model.dto.CuidadorDto;
import pe.cibertec.dawi.model.dto.PacienteDto;
import pe.cibertec.dawi.model.entity.CuidadorEntity;
import pe.cibertec.dawi.model.enums.EstadoEnum;
import pe.cibertec.dawi.model.enums.GeneroEnum;
import pe.cibertec.dawi.model.enums.PerfilEnum;
import pe.cibertec.dawi.service.CuidadorService;
import pe.cibertec.dawi.service.DocumentoService;
import pe.cibertec.dawi.service.PacienteService;
import pe.cibertec.dawi.service.ParentescoService;
import pe.cibertec.dawi.service.UbiDistritoService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Secured({"ROLE_MASTER", "ROLE_DIRECTOR", "ROLE_MEDICO", "ROLE_PACIENTE"})
@RequestMapping("/cuidador")
public class CuidadorController {

    @Autowired
    private CuidadorService cuidadorService;
    @Autowired
    private CuidadorConverter cuidadorConverter;

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private PacienteConverter pacienteConverter;

    @Autowired
    private DocumentoService documentoService;
    @Autowired
    private DocumentoConverter documentoConverter;

    @Autowired
    private UbiDistritoService ubiDistritoService;
    @Autowired
    private UbiDistritoConverter ubiDistritoConverter;

    @Autowired
    private ParentescoService parentescoService;
    @Autowired
    private ParentescoConverter parentescoConverter;

    @RequestMapping(value = "/mostrar/{id}", method = RequestMethod.GET)
    public String mostrar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Cuidador");
        model.addAttribute("opcion", "Mostrar");

        model.addAttribute("cuidador", cuidadorConverter.toDto(cuidadorService.getById(id)));

        return "cuidador/mostrar";
    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Cuidador");
        model.addAttribute("opcion", "Editar");

        model.addAttribute("cuidador", cuidadorConverter.toDto(cuidadorService.getById(id)));

        model.addAttribute("documentos", documentoConverter.toListDto(documentoService.listAll()));
        model.addAttribute("distritos", ubiDistritoConverter.toListDto(ubiDistritoService.listAll()));
        model.addAttribute("generoEnum", GeneroEnum.values());
        model.addAttribute("parentescos", parentescoConverter.toListDto(parentescoService.listAll()));

        return "cuidador/formulario";
    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(value = "/nuevo", method = RequestMethod.GET)
    public String nuevo(@RequestParam(value = "pacienteId") Long pacienteId, Model model) throws Exception {
        model.addAttribute("titulo", "Cuidador");
        model.addAttribute("opcion", "Nuevo");

        PacienteDto pacienteDto = pacienteConverter.toDto(pacienteService.getById(pacienteId));

        model.addAttribute("cuidador", CuidadorDto.builder()
                .genero(GeneroEnum.OTRO)
                .documento(documentoConverter.toDto(documentoService.getById(1L)))
                .parentesco(parentescoConverter.toDto(parentescoService.getById(1L)))
                .laboraActualmente(EstadoEnum.INACTIVO)
                .paciente(pacienteDto)
                .estado(EstadoEnum.ACTIVO)
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .perfil(PerfilEnum.CUIDADOR)
                .build());

        model.addAttribute("documentos", documentoConverter.toListDto(documentoService.listAll()));
        model.addAttribute("distritos", ubiDistritoConverter.toListDto(ubiDistritoService.listAll()));
        model.addAttribute("generoEnum", GeneroEnum.values());
        model.addAttribute("parentescos", parentescoConverter.toListDto(parentescoService.listAll()));

        return "cuidador/formulario";
    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(CuidadorDto dto, Model model) throws Exception {

        model.addAttribute("titulo", "Cuidador");
        model.addAttribute("opcion", "Búsqueda");

        CuidadorEntity newEntity = cuidadorService.saveOrUpdate(cuidadorConverter.toEntity(dto));

        if (newEntity != null) {
            model.addAttribute("paciente", cuidadorConverter.toDto(newEntity).getPaciente());
            model.addAttribute("cuidadores", cuidadorConverter.toListDto(cuidadorService.findCuidadorEntitiesByPaciente(newEntity.getPaciente())));
            model.addAttribute("success", "El registro de Cuidador se realizó con éxito.");
        } else {
            model.addAttribute("warning", "Ocurrió un error al registrar el Cuidador.");
        }

        return "cuidador/listar";
    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(value = "/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id) throws Exception {

        CuidadorEntity entity = cuidadorService.getById(id);
        cuidadorService.delete(id);

        return String.format("redirect:/paciente/%s/cuidador", cuidadorConverter.toDto(entity).getPaciente().getId());
    }

}
