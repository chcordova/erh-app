package pe.cibertec.dawi.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.dawi.converter.EnlaceInteresConverter;
import pe.cibertec.dawi.converter.IpressConverter;
import pe.cibertec.dawi.model.dto.EnlaceInteresDto;
import pe.cibertec.dawi.model.dto.IpressDto;
import pe.cibertec.dawi.model.entity.EnlaceInteresEntity;
import pe.cibertec.dawi.service.EnlaceInteresService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/enlaceintereses")
public class EnlaceInteresRestController {

    @Autowired
    private EnlaceInteresService enlaceInteresService;
    @Autowired
    private EnlaceInteresConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<EnlaceInteresEntity> getEntities() {

        return enlaceInteresService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<EnlaceInteresDto> getDtos() throws Exception {

        return converter.toListDto(enlaceInteresService.listAll());
    }

}
