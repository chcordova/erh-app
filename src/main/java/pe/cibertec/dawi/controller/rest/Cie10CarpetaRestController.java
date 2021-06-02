package pe.cibertec.dawi.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.dawi.converter.Cie10BloqueConverter;
import pe.cibertec.dawi.converter.Cie10CarpetaConverter;
import pe.cibertec.dawi.model.dto.Cie10BloqueDto;
import pe.cibertec.dawi.model.dto.Cie10CarpetaDto;
import pe.cibertec.dawi.model.entity.Cie10BloqueEntity;
import pe.cibertec.dawi.model.entity.Cie10CarpetaEntity;
import pe.cibertec.dawi.service.Cie10CarpetaService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cie10carpetas")
public class Cie10CarpetaRestController {

    @Autowired
    private Cie10CarpetaService cie10CarpetaService;
    @Autowired
    private Cie10CarpetaConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<Cie10CarpetaEntity> getEntities() {

        return cie10CarpetaService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<Cie10CarpetaDto> getDtos() throws Exception {

        return converter.toListDto(cie10CarpetaService.listAll());
    }

}
