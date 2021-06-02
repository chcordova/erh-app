package pe.cibertec.dawi.model.entity;

import lombok.Data;

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

@Entity
@Data
@Table(name = "provincias")
public class UbiProvinciaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idprovincia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "provincia")
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "iddepartamento")
    private UbiDepartamentoEntity departamento;
    @NotBlank
    @Column(name = "codprovincia")
    private String codigo;

}
