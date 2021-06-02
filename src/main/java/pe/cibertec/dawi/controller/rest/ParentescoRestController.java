package pe.cibertec.dawi.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.dawi.converter.ParentescoConverter;
import pe.cibertec.dawi.model.dto.ParentescoDto;
import pe.cibertec.dawi.model.entity.ParentescoEntity;
import pe.cibertec.dawi.service.ParentescoService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/parentescos")
public class ParentescoRestController {

    @Autowired
    private ParentescoService parentescoService;
    @Autowired
    private ParentescoConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<ParentescoEntity> getEntities() {

        return parentescoService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<ParentescoDto> getDtos() throws Exception {
        return converter.toListDto(parentescoService.listAll());
    }

}
