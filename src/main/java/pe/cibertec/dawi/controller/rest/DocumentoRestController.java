package pe.cibertec.dawi.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.dawi.converter.DocumentoConverter;
import pe.cibertec.dawi.model.dto.DocumentoDto;
import pe.cibertec.dawi.model.entity.DocumentoEntity;
import pe.cibertec.dawi.service.DocumentoService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/documentos")
public class DocumentoRestController {

    @Autowired
    private DocumentoService documentoService;
    @Autowired
    private DocumentoConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<DocumentoEntity> getEntities() {

        return documentoService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<DocumentoDto> getDtos() throws Exception {
        return converter.toListDto(documentoService.listAll());
    }

}
