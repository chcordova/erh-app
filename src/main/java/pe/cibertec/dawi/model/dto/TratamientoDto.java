package pe.cibertec.dawi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.cibertec.dawi.model.enums.EstadoEnum;
import pe.cibertec.dawi.model.enums.PerfilEnum;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TratamientoDto implements Serializable {


    private Long id;
    private EstadoEnum tratamientoFarmacologicoEspecifico;
    private String detalleTratamientoFarmacologicoEspecifico;
    private EstadoEnum tratamientoFarmacologicoNoEspecifico;
    private String detalleTratamientoFarmacologicoNoEspecifico;
    private EstadoEnum tratamientoNoFarmacologico;
    private String detalleTratamientoNoFarmacologico;
    private EstadoEnum terapiaFisica;
    private EstadoEnum ergoterapia;
    private EstadoEnum terapiaNutricionalEspecifica;
    private EstadoEnum medicinaTradicional;
    private EstadoEnum medicinaAlternativa;
    private EnfermedadDto enfermedad;

    private EstadoEnum estado;
    private String fecRegistro;
    private String fecModificacion;

}
