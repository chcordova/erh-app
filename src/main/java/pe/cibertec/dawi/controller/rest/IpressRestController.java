package pe.cibertec.dawi.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.dawi.converter.IpressConverter;
import pe.cibertec.dawi.model.dto.IpressDto;
import pe.cibertec.dawi.model.entity.IpressEntity;
import pe.cibertec.dawi.service.IpressService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/ipresses")
public class IpressRestController {

    @Autowired
    private IpressService ipressService;
    @Autowired
    private IpressConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<IpressEntity> getEntities() {

        return ipressService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<IpressDto> getDtos() throws Exception {

        return converter.toListDto(ipressService.listAll());
    }

}
