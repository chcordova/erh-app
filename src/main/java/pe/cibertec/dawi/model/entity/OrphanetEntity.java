package pe.cibertec.dawi.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Data
@Table(name = "orphanet")
public class OrphanetEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idorphanet")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "strorphanet")
    private String nombre;
    @NotBlank
    @Column(name = "strcodorphanet")
    private String codigo;

}
