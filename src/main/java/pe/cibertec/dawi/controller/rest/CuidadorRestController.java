package pe.cibertec.dawi.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.dawi.converter.CuidadorConverter;
import pe.cibertec.dawi.model.dto.CuidadorDto;
import pe.cibertec.dawi.model.entity.CuidadorEntity;
import pe.cibertec.dawi.service.CuidadorService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cuidadores")
public class CuidadorRestController {

    @Autowired
    private CuidadorService cuidadorService;
    @Autowired
    private CuidadorConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<CuidadorEntity> getEntities() {

        return cuidadorService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<CuidadorDto> getDtos() throws Exception {

        return converter.toListDto(cuidadorService.listAll());
    }

}
