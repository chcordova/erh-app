package pe.cibertec.dawi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "departamentos")
public class UbiDepartamentoEntity implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "iddepartamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "departamento")
    private String nombre;
    @NotBlank
    @Column(name = "coddepartamento")
    private String codigo;

    @JsonIgnore
    @OneToMany(mappedBy = "departamento")
    private List<UbiProvinciaEntity> listaProvincia;
}
