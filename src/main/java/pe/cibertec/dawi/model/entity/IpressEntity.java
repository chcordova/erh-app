package pe.cibertec.dawi.model.entity;

import lombok.Data;
import pe.cibertec.dawi.model.enums.EstadoEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "ipress")
public class IpressEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idipress")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "stripress")
    private String nombre;
    @NotBlank
    @Column(name = "strcodipress")
    private String codigo;
    @NotBlank
    @Column(name = "strdireccion")
    private String direccion;
    @ManyToOne
    @JoinColumn(name = "iddistrito")
    private UbiDistritoEntity distrito;
    @NotBlank
    @Column(name = "strtelefono")
    private String telefono;
    @NotBlank
    @Column(name = "strruc")
    private String ruc;

    @Column(name = "chrestado")
    private EstadoEnum estado;
    @Column(name = "datfregistro")
    private Date fecRegistro;
    @Column(name = "datfmodificacion")
    private Date fecModificacion;

}
