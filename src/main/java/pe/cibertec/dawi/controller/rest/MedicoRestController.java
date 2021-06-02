package pe.cibertec.dawi.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.dawi.converter.EnfermedadConverter;
import pe.cibertec.dawi.converter.MedicoConverter;
import pe.cibertec.dawi.model.dto.EnfermedadDto;
import pe.cibertec.dawi.model.dto.MedicoDto;
import pe.cibertec.dawi.model.entity.EnfermedadEntity;
import pe.cibertec.dawi.model.entity.MedicoEntity;
import pe.cibertec.dawi.service.EnfermedadService;
import pe.cibertec.dawi.service.MedicoService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/medicos")
public class MedicoRestController {

    @Autowired
    private MedicoService medicoService;
    @Autowired
    private MedicoConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<MedicoEntity> getEntities() {

        return medicoService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<MedicoDto> getDtos() throws Exception {
        return converter.toListDto(medicoService.listAll());
    }

}
