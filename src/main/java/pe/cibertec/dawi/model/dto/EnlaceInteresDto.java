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
public class EnlaceInteresDto implements Serializable {

    private Long id;
    private String nombre;
    private String url;
    private String dirigido;
    private String direccion;
    private String telefono;
    private String email;

    private EstadoEnum estado;
    private String fecRegistro;
    private String fecModificacion;


}
