package pe.cibertec.dawi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

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
    @NotBlank
    @Column(name = "codprovincia")
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "iddepartamento")
    private UbiDepartamentoEntity departamento;

    @JsonIgnore
    @OneToMany(mappedBy = "provincia")
    private List<UbiDistritoEntity> listaDistrito;
}
