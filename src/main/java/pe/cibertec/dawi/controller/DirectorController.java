package pe.cibertec.dawi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.cibertec.dawi.converter.DirectorConverter;
import pe.cibertec.dawi.converter.IpressConverter;
import pe.cibertec.dawi.model.dto.DirectorDto;
import pe.cibertec.dawi.model.entity.DirectorEntity;
import pe.cibertec.dawi.model.enums.EstadoEnum;
import pe.cibertec.dawi.model.enums.PerfilEnum;
import pe.cibertec.dawi.service.DirectorService;
import pe.cibertec.dawi.service.IpressService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Secured({"ROLE_MASTER", "ROLE_ADMINISTRADOR", "ROLE_DIRECTOR"})
@RequestMapping("/director")
public class DirectorController {

    @Autowired
    private DirectorService directorService;
    @Autowired
    private DirectorConverter directorConverter;

    @Autowired
    private IpressService ipressService;
    @Autowired
    private IpressConverter ipressConverter;

    @RequestMapping(method = RequestMethod.GET)
    public String listar(Model model) throws Exception {
        model.addAttribute("titulo", "Director");
        model.addAttribute("opcion", "Búsqueda");
        model.addAttribute("directores", directorConverter.toListDto(directorService.listAll()));
        return "director/listar";
    }

    @Secured({"ROLE_MASTER", "ROLE_ADMINISTRADOR"})
    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Director");
        model.addAttribute("opcion", "Editar");
        model.addAttribute("director", directorConverter.toDto(directorService.getById(id)));
        model.addAttribute("ipresses", ipressConverter.toListDto(ipressService.listAll()));
        return "director/formulario";
    }

    @Secured({"ROLE_MASTER", "ROLE_ADMINISTRADOR"})
    @RequestMapping(value = "/nuevo", method = RequestMethod.GET)
    public String nuevo(Model model) throws Exception {
        model.addAttribute("titulo", "Director");
        model.addAttribute("opcion", "Nuevo");
        model.addAttribute("director", DirectorDto.builder()
                .estado(EstadoEnum.ACTIVO)
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .perfil(PerfilEnum.DIRECTOR)
                .build());
        model.addAttribute("ipresses", ipressConverter.toListDto(ipressService.listAll()));
        return "director/formulario";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(DirectorDto dto, Model model) throws Exception {
        DirectorEntity newEntity = directorService.saveOrUpdate(directorConverter.toEntity(dto));
        model.addAttribute("newEntity", directorConverter.toDto(newEntity));
        return "redirect:/director/";
    }

    @Secured({"ROLE_MASTER", "ROLE_ADMINISTRADOR"})
    @RequestMapping(value = "/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id) throws Exception {
        directorService.delete(id);
        return "redirect:/director/";
    }

}
