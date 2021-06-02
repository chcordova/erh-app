package pe.cibertec.dawi.model.entity;

import lombok.Data;
import pe.cibertec.dawi.model.enums.EstadoEnum;
import pe.cibertec.dawi.model.enums.PerfilEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "medicotratante")
public class MedicoEntity implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "idmedicotratante")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "strnombres")
    private String nombre;
    @Column(name = "strapepaterno")
    private String apePaterno;
    @Column(name = "strapematerno")
    private String apeMaterno;
    //    @Column(name = "datfnacimiento")
//    private Date fecNacimiento;
    @ManyToOne
    @JoinColumn(name = "iddocumento")
    private DocumentoEntity documento;
    @Column(name = "strnumdocumento")
    private String nroDocumento;
    //    @Enumerated(EnumType.ORDINAL)
//    @Column(name = "chrgenero")
//    private GeneroEnum genero;
    @Column(name = "strrutaimagen")
    private String rutaImagen;
//    @ManyToOne
//    @JoinColumn(name = "iddistrito")
//    private UbiDistritoEntity distritoNacimiento;
//    @Enumerated(EnumType.ORDINAL)
//    @Column(name = "chrestavivo")
//    private EstadoEnum condicion;
//    @Column(name = "chrnacionalidad")
//    private NacionalidadEnum origenNacionalidad;
//    @Column(name = "strpais")
//    private String origenPais;
//    @Column(name = "strestado")
//    private String origenEstado;
//    @Column(name = "strciudad")
//    private String origenCiudad;
//    @Column(name = "strlugarnacimiento")
//    private String lugarNacimiento;
//    @Column(name = "stremail")
//    private String email;
//    @ManyToOne
//    @JoinColumn(name = "iddistritoactual")
//    private UbiDistritoEntity distritoResidencia;
//    @Column(name = "strdireccionactual")
//    private String direccionActual;
//    @Column(name = "strlugarprocedencia")
//    private String lugarProcedencia;
//    @Column(name = "strtelefonofijo")
//    private String telFijo;
//    @Column(name = "strtelefonomovil")
//    private String telMovil;

    @NotBlank
    @Column(name = "strcmp")
    private String cmp;
    @NotBlank
    @Column(name = "strrne")
    private String rne;
    @NotBlank
    @Column(name = "strespecialidad")
    private String especialidad;
    @ManyToOne
    @JoinColumn(name = "idipress")
    private IpressEntity ipress;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "idperfil")
    private PerfilEnum perfil;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrestado")
    private EstadoEnum estado;
    @Column(name = "datfregistro")
    private Date fecRegistro;
    @Column(name = "datfmodificacion")
    private Date fecModificacion;

}
