package pe.cibertec.dawi.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.dawi.converter.DirectorConverter;
import pe.cibertec.dawi.model.dto.DirectorDto;
import pe.cibertec.dawi.model.entity.DirectorEntity;
import pe.cibertec.dawi.service.DirectorService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/directores")
public class DirectorRestController {

    @Autowired
    private DirectorService directorService;
    @Autowired
    private DirectorConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<DirectorEntity> getEntities() {

        return directorService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<DirectorDto> getDtos() throws Exception {

        return converter.toListDto(directorService.listAll());
    }

}
