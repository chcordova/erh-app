package pe.cibertec.dawi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.cibertec.dawi.converter.DocumentoConverter;
import pe.cibertec.dawi.converter.ParentescoConverter;
import pe.cibertec.dawi.model.dto.DocumentoDto;
import pe.cibertec.dawi.model.dto.ParentescoDto;
import pe.cibertec.dawi.model.entity.DocumentoEntity;
import pe.cibertec.dawi.model.entity.ParentescoEntity;
import pe.cibertec.dawi.model.enums.EstadoEnum;
import pe.cibertec.dawi.service.DocumentoService;
import pe.cibertec.dawi.service.ParentescoService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Secured({"ROLE_MASTER", "ROLE_ADMINISTRADOR"})
@RequestMapping("/parametro")
public class ParametroController {

    @Autowired
    private DocumentoService documentoService;
    @Autowired
    private DocumentoConverter documentoConverter;

    @Autowired
    private ParentescoService parentescoService;
    @Autowired
    private ParentescoConverter parentescoConverter;

    @RequestMapping(method = RequestMethod.GET)
    public String listar(Model model) throws Exception {
        model.addAttribute("titulo", "Parámetro");
        model.addAttribute("opcion", "Búsqueda");
        model.addAttribute("documentos", documentoConverter.toListDto(documentoService.listAll()));
        model.addAttribute("parentescos", parentescoConverter.toListDto(parentescoService.listAll()));
        return "parametro/listar";
    }

    @RequestMapping(value = "documento/editar/{id}", method = RequestMethod.GET)
    public String documentoEditar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Parámetro");
        model.addAttribute("opcion", "Editar Tipo Documento");
        model.addAttribute("documento", documentoConverter.toDto(documentoService.getById(id)));
        return "parametro/formularioDocumento";
    }

    @RequestMapping(value = "documento/nuevo", method = RequestMethod.GET)
    public String documentoNuevo(Model model) throws Exception {
        model.addAttribute("titulo", "Parámetro");
        model.addAttribute("opcion", "Nuevo Tipo Documento");
        model.addAttribute("documento", DocumentoDto.builder()
                .estado(EstadoEnum.ACTIVO)
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .build());
        return "parametro/formularioDocumento";
    }

    @RequestMapping(value = "/documento", method = RequestMethod.POST)
    public String documentoSaveOrUpdate(DocumentoDto dto, Model model) throws Exception {
        DocumentoEntity newEntity = documentoService.saveOrUpdate(documentoConverter.toEntity(dto));
        model.addAttribute("newEntity", documentoConverter.toDto(newEntity));
        return "redirect:/parametro/";
    }

    @RequestMapping(value = "documento/eliminar/{id}")
    public String documentoDelete(@PathVariable(value = "id") Long id) throws Exception {
        documentoService.delete(id);
        return "redirect:/parametro/";
    }

    @RequestMapping(value = "parentesco/editar/{id}", method = RequestMethod.GET)
    public String parentescoEditar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Parámetro");
        model.addAttribute("opcion", "Editar Parentesco");
        model.addAttribute("parentesco", parentescoConverter.toDto(parentescoService.getById(id)));
        return "parametro/formularioParentesco";
    }

    @RequestMapping(value = "parentesco/nuevo", method = RequestMethod.GET)
    public String parentescoNuevo(Model model) throws Exception {
        model.addAttribute("titulo", "Parámetro");
        model.addAttribute("opcion", "Nuevo Parentesco");
        model.addAttribute("parentesco", ParentescoDto.builder()
                .estado(EstadoEnum.ACTIVO)
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .build());
        return "parametro/formularioParentesco";
    }

    @RequestMapping(value = "/parentesco", method = RequestMethod.POST)
    public String parentescoSaveOrUpdate(ParentescoDto dto, Model model) throws Exception {
        ParentescoEntity newEntity = parentescoService.saveOrUpdate(parentescoConverter.toEntity(dto));
        model.addAttribute("newEntity", parentescoConverter.toDto(newEntity));
        return "redirect:/parametro/";
    }

    @RequestMapping(value = "parentesco/eliminar/{id}")
    public String parentescoDelete(@PathVariable(value = "id") Long id) throws Exception {
        parentescoService.delete(id);
        return "redirect:/parametro/";
    }

}
