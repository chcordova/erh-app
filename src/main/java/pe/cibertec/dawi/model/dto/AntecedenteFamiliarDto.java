package pe.cibertec.dawi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.cibertec.dawi.model.enums.EstadoEnum;
import pe.cibertec.dawi.model.enums.GeneroEnum;
import pe.cibertec.dawi.model.enums.PerfilEnum;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AntecedenteFamiliarDto implements Serializable {

    private Long id;

    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private String fecNacimiento;
    private Integer edad;
    private DocumentoDto documento;
    private String nroDocumento;
    private GeneroEnum genero;
    private String rutaImagen;
    //    private UbiDistritoDto distritoNacimiento;
    private EstadoEnum condicion;
//    private NacionalidadEnum origenNacionalidad;
//    private String origenPais;
//    private String origenEstado;
//    private String origenCiudad;
//    private String lugarNacimiento;
//    private String email;
//    private UbiDistritoDto distritoResidencia;
//    private String direccionActual;
//    private String lugarProcedencia;
//    private String telFijo;
//    private String telMovil;

    private ParentescoDto parentesco;
    //    private EstadoEnum familiarCondicion;
    private EstadoEnum mismaEnfermedad;
    private String fecDiagnostico;
    private String detalleEnfermedad;

    private PacienteDto paciente;

    private PerfilEnum perfil;

    private EstadoEnum estado;
    private String fecRegistro;
    private String fecModificacion;

}
