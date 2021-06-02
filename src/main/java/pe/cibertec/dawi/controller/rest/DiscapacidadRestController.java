package pe.cibertec.dawi.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.dawi.converter.CuidadorConverter;
import pe.cibertec.dawi.converter.DiscapacidadConverter;
import pe.cibertec.dawi.model.dto.CuidadorDto;
import pe.cibertec.dawi.model.dto.DiscapacidadDto;
import pe.cibertec.dawi.model.entity.CuidadorEntity;
import pe.cibertec.dawi.model.entity.DiscapacidadEntity;
import pe.cibertec.dawi.service.CuidadorService;
import pe.cibertec.dawi.service.DiscapacidadService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/discapacidades")
public class DiscapacidadRestController {

    @Autowired
    private DiscapacidadService discapacidadService;
    @Autowired
    private DiscapacidadConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<DiscapacidadEntity> getEntities() {

        return discapacidadService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<DiscapacidadDto> getDtos() throws Exception {

        return converter.toListDto(discapacidadService.listAll());
    }

}
