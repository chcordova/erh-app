package pe.cibertec.dawi.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.dawi.converter.MedicoConverter;
import pe.cibertec.dawi.converter.TratamientoConverter;
import pe.cibertec.dawi.model.dto.MedicoDto;
import pe.cibertec.dawi.model.dto.TratamientoDto;
import pe.cibertec.dawi.model.entity.MedicoEntity;
import pe.cibertec.dawi.model.entity.TratamientoEntity;
import pe.cibertec.dawi.service.MedicoService;
import pe.cibertec.dawi.service.TratamientoService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/tratamientos")
public class TratamientoRestController {

    @Autowired
    private TratamientoService tratamientoService;
    @Autowired
    private TratamientoConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<TratamientoEntity> getEntities() {

        return tratamientoService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<TratamientoDto> getDtos() throws Exception {
        return converter.toListDto(tratamientoService.listAll());
    }

}
