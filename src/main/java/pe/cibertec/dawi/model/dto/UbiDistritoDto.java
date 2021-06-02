package pe.cibertec.dawi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UbiDistritoDto implements Serializable {

    private Long id;
    private String nombre;
    private UbiProvinciaDto provincia;
    private String codigo;

}
