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
@Table(name = "carpetacie10")
public class Cie10CarpetaEntity implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "idcarpetacie10")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "strcarpetacie10")
    private String nombre;
    @NotBlank
    @Column(name = "strcodbloquecie10")
    private String codigo;
    @ManyToOne
    @JoinColumn(name = "idbloquecie10")
    private Cie10BloqueEntity cie10Bloque;

}
