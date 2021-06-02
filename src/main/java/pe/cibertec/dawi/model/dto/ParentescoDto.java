package pe.cibertec.dawi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.cibertec.dawi.model.enums.EstadoEnum;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParentescoDto implements Serializable {

    private Long id;
    private String nombre;

    private EstadoEnum estado;
    private String fecRegistro;
    private String fecModificacion;


}
