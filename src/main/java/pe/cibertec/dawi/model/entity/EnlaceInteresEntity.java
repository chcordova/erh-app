package pe.cibertec.dawi.model.entity;

import lombok.Data;
import pe.cibertec.dawi.model.enums.EstadoEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "enlaceinteres")
public class EnlaceInteresEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idenlace")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "strenlace")
    private String nombre;
    @Column(name = "strpaginaweb")
    private String url;
    @Column(name = "strdirigidoa")
    private String dirigido;
    @Column(name = "strdireccion")
    private String direccion;
    @Column(name = "strtelefono")
    private String telefono;
    @Column(name = "stremail")
    private String email;
    @Column(name = "chrestado")
    private EstadoEnum estado;
    @Column(name = "datfregistro")
    private Date fecRegistro;
    @Column(name = "datfmodificacion")
    private Date fecModificacion;

}
