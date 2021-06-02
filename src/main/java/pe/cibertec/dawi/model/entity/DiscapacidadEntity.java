package pe.cibertec.dawi.model.entity;

import lombok.Data;
import pe.cibertec.dawi.model.enums.EstadoEnum;

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
import java.util.Date;

@Entity
@Data
@Table(name = "discapacidad")
public class DiscapacidadEntity {

    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "iddiscapacidad")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrlimitacionfuncional")
    private EstadoEnum limitacionFuncional;
    @Column(name = "strlimitacionfuncional")
    private String detallelimitacionfuncional;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrinscritoconadis")
    private EstadoEnum inscritoConadis;
    @Column(name = "strobservaciones")
    private String detalleObservaciones;

    @ManyToOne
    @JoinColumn(name = "idpaciente")
    private PacienteEntity paciente;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrestado")
    private EstadoEnum estado;
    @Column(name = "datfregistro")
    private Date fecRegistro;
    @Column(name = "datfmodificacion")
    private Date fecModificacion;

}
