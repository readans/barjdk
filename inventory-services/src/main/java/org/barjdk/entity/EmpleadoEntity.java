package org.barjdk.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "EMPLEADO")
public class EmpleadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_EMPLEADO_ID")
    private Integer pkEmpleadoId;

    @Column(name = "DOCUMENTO")
    private Integer documento;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

    @Column(name = "FK_ROL_ID")
    private Integer fkRolId;

    @Column(name = "FK_SEDE_ID")
    private Integer fkSedeId;
}

