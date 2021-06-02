package pe.cibertec.dawi.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.dawi.converter.DocumentoConverter;
import pe.cibertec.dawi.converter.DocumentoEnfermedadConverter;
import pe.cibertec.dawi.model.dto.DocumentoDto;
import pe.cibertec.dawi.model.dto.DocumentoEnfermedadDto;
import pe.cibertec.dawi.model.entity.DocumentoEnfermedadEntity;
import pe.cibertec.dawi.model.entity.DocumentoEntity;
import pe.cibertec.dawi.service.DocumentoEnfermedadService;
import pe.cibertec.dawi.service.DocumentoService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/documentosenfermedades")
public class DocumentoEnfermedadRestController {

    @Autowired
    private DocumentoEnfermedadService documentoEnfermedadService;
    @Autowired
    private DocumentoEnfermedadConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<DocumentoEnfermedadEntity> getEntities() {

        return documentoEnfermedadService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<DocumentoEnfermedadDto> getDtos() throws Exception {
        return converter.toListDto(documentoEnfermedadService.listAll());
    }

}
