package pe.cibertec.dawi.model.entity;

import pe.cibertec.dawi.model.enums.EstadoEnum;
import pe.cibertec.dawi.model.enums.GeneroEnum;
import pe.cibertec.dawi.model.enums.NacionalidadEnum;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

public class PersonaEntity implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "idpersona")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "strnombres")
    private String nombre;
    @NotBlank
    @Column(name = "strapepaterno")
    private String apePaterno;
    @Column(name = "strapematerno")
    private String apeMaterno;
    @Column(name = "datfnacimiento")
    private Date fecNacimiento;
    @ManyToOne
    @JoinColumn(name = "iddocumento")
    private DocumentoEntity documento;
    @NotBlank
    @Column(name = "strnumdocumento")
    private String nroDocumento;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrgenero")
    private GeneroEnum genero;
    @Column(name = "strrutaimagen")
    private String rutaImagen;
    @ManyToOne
    @JoinColumn(name = "iddistrito")
    private UbiDistritoEntity distritoNacimiento;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrestavivo")
    private EstadoEnum condicion;
    @Column(name = "chrnacionalidad")
    private NacionalidadEnum origenNacionalidad;
    @Column(name = "strpais")
    private String origenPais;
    @Column(name = "strestado")
    private String origenEstado;
    @Column(name = "strciudad")
    private String origenCiudad;
    @Column(name = "strlugarnacimiento")
    private String lugarNacimiento;
    @Column(name = "stremail")
    private String email;
    @ManyToOne
    @JoinColumn(name = "iddistritoactual")
    private UbiDistritoEntity distritoResidencia;
    @Column(name = "strdireccionactual")
    private String direccionActual;
    @Column(name = "strlugarprocedencia")
    private String lugarProcedencia;
    @Column(name = "strtelefonofijo")
    private String telFijo;
    @Column(name = "strtelefonomovil")
    private String telMovil;

    @Column(name = "datfregistro")
    private Date fecRegistro;
    @Column(name = "datfmodificacion")
    private Date fecModificacion;

}
