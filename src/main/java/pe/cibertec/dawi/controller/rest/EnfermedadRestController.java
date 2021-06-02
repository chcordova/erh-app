package pe.cibertec.dawi.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.dawi.converter.DocumentoEnfermedadConverter;
import pe.cibertec.dawi.converter.EnfermedadConverter;
import pe.cibertec.dawi.model.dto.DocumentoEnfermedadDto;
import pe.cibertec.dawi.model.dto.EnfermedadDto;
import pe.cibertec.dawi.model.entity.DocumentoEnfermedadEntity;
import pe.cibertec.dawi.model.entity.EnfermedadEntity;
import pe.cibertec.dawi.service.DocumentoEnfermedadService;
import pe.cibertec.dawi.service.EnfermedadService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/enfermedades")
public class EnfermedadRestController {

    @Autowired
    private EnfermedadService enfermedadService;
    @Autowired
    private EnfermedadConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<EnfermedadEntity> getEntities() {

        return enfermedadService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<EnfermedadDto> getDtos() throws Exception {
        return converter.toListDto(enfermedadService.listAll());
    }

}
