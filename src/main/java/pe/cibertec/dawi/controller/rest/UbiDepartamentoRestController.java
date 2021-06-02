package pe.cibertec.dawi.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.dawi.converter.UbiDepartamentoConverter;
import pe.cibertec.dawi.model.dto.UbiDepartamentoDto;
import pe.cibertec.dawi.model.entity.UbiDepartamentoEntity;
import pe.cibertec.dawi.service.UbiDepartamentoService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/departamentos")
public class UbiDepartamentoRestController {

    @Autowired
    private UbiDepartamentoService ubiDepartamentoService;
    @Autowired
    private UbiDepartamentoConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<UbiDepartamentoEntity> getEntities() {

        return ubiDepartamentoService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<UbiDepartamentoDto> getDtos() throws Exception {
        return converter.toListDto(ubiDepartamentoService.listAll());
    }

}
