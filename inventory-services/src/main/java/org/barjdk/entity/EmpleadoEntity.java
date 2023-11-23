package org.barjdk.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String documento;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

    @Column(name = "USUARIO_ACCESO")
    private String usuarioAcceso;

    @Column(name = "CLAVE_ACCESO")
    private String claveAcceso;

    @OneToOne
    @JoinColumn(name = "FK_ROL_ID")
    private RolEntity rol;

    @OneToOne
    @JoinColumn(name = "FK_SEDE_ID")
    private SedeEntity sede;
}

