package pe.cibertec.dawi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.cibertec.dawi.converter.EnlaceInteresConverter;
import pe.cibertec.dawi.model.dto.EnlaceInteresDto;
import pe.cibertec.dawi.model.entity.EnlaceInteresEntity;
import pe.cibertec.dawi.model.enums.EstadoEnum;
import pe.cibertec.dawi.service.EnlaceInteresService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Secured({"ROLE_MASTER", "ROLE_ADMINISTRADOR", "ROLE_DIRECTOR", "ROLE_MEDICO", "ROLE_PACIENTE"})
@RequestMapping("/enlaceinteres")
public class EnlaceInteresController {

    @Autowired
    private EnlaceInteresService enlaceInteresService;
    @Autowired
    private EnlaceInteresConverter enlaceInteresConverter;

    @RequestMapping(method = RequestMethod.GET)
    public String listar(Model model) throws Exception {
        model.addAttribute("titulo", "Enlaces Interés");
        model.addAttribute("opcion", "Búsqueda");
        model.addAttribute("enlaceIntereses", enlaceInteresConverter.toListDto(enlaceInteresService.listAll()));
        return "enlaceinteres/listar";
    }

    @Secured({"ROLE_MASTER"})
    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Enlaces Interés");
        model.addAttribute("opcion", "Editar");
        model.addAttribute("enlaceInteres", enlaceInteresConverter.toDto(enlaceInteresService.getById(id)));
        
        return "enlaceinteres/formulario";
    }

    @Secured({"ROLE_MASTER"})
    @RequestMapping(value = "/nuevo", method = RequestMethod.GET)
    public String nuevo(Model model) throws Exception {
        model.addAttribute("titulo", "Enlaces Interés");
        model.addAttribute("opcion", "Nuevo");
        model.addAttribute("enlaceInteres", EnlaceInteresDto.builder()
                .estado(EstadoEnum.ACTIVO)
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .build());
        
        return "enlaceinteres/formulario";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(EnlaceInteresDto dto, Model model) throws Exception {
        EnlaceInteresEntity newEntity = enlaceInteresService.saveOrUpdate(enlaceInteresConverter.toEntity(dto));
        model.addAttribute("newEntity", enlaceInteresConverter.toDto(newEntity));
        return "redirect:/enlaceinteres/";
    }
    

    @Secured({"ROLE_MASTER"})
    @RequestMapping(value = "/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id) throws Exception {
        enlaceInteresService.delete(id);
        return "redirect:/enlaceinteres/";
    }

}
