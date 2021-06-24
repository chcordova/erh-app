package pe.cibertec.dawi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.cibertec.dawi.converter.DocumentoConverter;
import pe.cibertec.dawi.converter.IpressConverter;
import pe.cibertec.dawi.converter.MedicoConverter;
import pe.cibertec.dawi.model.dto.MedicoDto;
import pe.cibertec.dawi.model.entity.MedicoEntity;
import pe.cibertec.dawi.model.enums.EstadoEnum;
import pe.cibertec.dawi.model.enums.PerfilEnum;
import pe.cibertec.dawi.service.DocumentoService;
import pe.cibertec.dawi.service.IpressService;
import pe.cibertec.dawi.service.MedicoService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Secured({"ROLE_MASTER", "ROLE_ADMINISTRADOR", "ROLE_DIRECTOR"})
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;
    @Autowired
    private MedicoConverter medicoConverter;

    @Autowired
    private DocumentoService documentoService;
    @Autowired
    private DocumentoConverter documentoConverter;

    @Autowired
    private IpressService ipressService;
    @Autowired
    private IpressConverter ipressConverter;


    @RequestMapping(method = RequestMethod.GET)
    public String listar(Model model) throws Exception {
        model.addAttribute("titulo", "Médico Tratante");
        model.addAttribute("opcion", "Búsqueda");
        model.addAttribute("medicos", medicoConverter.toListDto(medicoService.listAll()));
        return "medico/listar";
    }

    @RequestMapping(value = "/mostrar/{id}", method = RequestMethod.GET)
    public String mostrar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Médico Tratante");
        model.addAttribute("opcion", "Mostrar");
        model.addAttribute("medico", medicoConverter.toDto(medicoService.getById(id)));
        return "medico/mostrar";
    }


    @Secured({"ROLE_MASTER", "ROLE_ADMINISTRADOR"})
    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Médico Tratante");
        model.addAttribute("opcion", "Editar");

        model.addAttribute("medico", medicoConverter.toDto(medicoService.getById(id)));
        model.addAttribute("documentos", documentoConverter.toListDto(documentoService.listAll()));
        model.addAttribute("ipresses", ipressConverter.toListDto(ipressService.listAll()));

        return "medico/formulario";
    }

    @Secured({"ROLE_MASTER", "ROLE_ADMINISTRADOR"})
    @RequestMapping(value = "/nuevo", method = RequestMethod.GET)
    public String nuevo(Model model) throws Exception {
        model.addAttribute("titulo", "Médico Tratante");
        model.addAttribute("opcion", "Nuevo");
        model.addAttribute("medico", MedicoDto.builder()
                .documento(documentoConverter.toDto(documentoService.getById(1L)))
                .estado(EstadoEnum.ACTIVO)
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .perfil(PerfilEnum.MEDICO)
                .build());

        model.addAttribute("documentos", documentoConverter.toListDto(documentoService.listAll()));
        model.addAttribute("ipresses", ipressConverter.toListDto(ipressService.listAll()));

        return "medico/formulario";
    }

    @Secured({"ROLE_MASTER", "ROLE_ADMINISTRADOR"})
    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(MedicoDto dto, Model model) throws Exception {

        MedicoEntity newEntity = medicoService.saveOrUpdate(medicoConverter.toEntity(dto));
        model.addAttribute("newEntity", medicoConverter.toDto(newEntity));

        return "redirect:/medico/";
    }

    @Secured({"ROLE_MASTER", "ROLE_ADMINISTRADOR"})
    @RequestMapping(value = "/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id) throws Exception {
        medicoService.delete(id);
        return "redirect:/medico/";
    }


}
