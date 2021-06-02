package pe.cibertec.dawi.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.dawi.converter.AntecedenteFamiliarConverter;
import pe.cibertec.dawi.model.dto.AntecedenteFamiliarDto;
import pe.cibertec.dawi.model.entity.AntecedenteFamiliarEntity;
import pe.cibertec.dawi.service.AntecedenteFamiliarService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/antecedentesfamiliares")
public class AntecedenteFamiliarRestController {

    @Autowired
    private AntecedenteFamiliarService antecedenteFamiliarService;
    @Autowired
    private AntecedenteFamiliarConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<AntecedenteFamiliarEntity> getEntities() {

        return antecedenteFamiliarService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<AntecedenteFamiliarDto> getDtos() throws Exception {

        return converter.toListDto(antecedenteFamiliarService.listAll());
    }

}
