package pe.cibertec.dawi.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.dawi.converter.UbiProvinciaConverter;
import pe.cibertec.dawi.model.dto.UbiProvinciaDto;
import pe.cibertec.dawi.model.entity.UbiProvinciaEntity;
import pe.cibertec.dawi.service.UbiProvinciaService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/provincias")
public class UbiProvinciaRestController {

    @Autowired
    private UbiProvinciaService ubiProvinciaService;
    @Autowired
    private UbiProvinciaConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<UbiProvinciaEntity> getEntities() {

        return ubiProvinciaService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<UbiProvinciaDto> getDtos() throws Exception {

        return converter.toListDto(ubiProvinciaService.listAll());
    }

}
