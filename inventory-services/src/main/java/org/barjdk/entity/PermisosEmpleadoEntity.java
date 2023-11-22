package org.barjdk.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "EMPLEADO")
public class PermisosEmpleadoEntity {

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

    @JsonIgnore
    @Column(name = "USUARIO_ACCESO")
    private String usuarioAcceso;

    @JsonIgnore
    @Column(name = "CLAVE_ACCESO")
    private String claveAcceso;

    @OneToOne
    @JoinColumn(name = "FK_ROL_ID")
    private Rol rol;

    @Column(name = "FK_SEDE_ID")
    private Integer fkSedeId;
}

@Data
@Entity
@Table(name = "ROL")
class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ROL_ID ")
    private Integer pkRolId;

    @Column(name = "NOMBRE")
    private String nombre;

    @OneToMany(mappedBy = "fkRolId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<PermisoRol> permisos;

}

@Data
@Entity
@Table(name = "PERMISO_ROL")
class PermisoRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_PERMISO_ROL_ID ")
    @JsonIgnore
    private Integer pkPermisoRolId;

    @ManyToOne
    @JoinColumn(name = "FK_PERMISO_ID")
    private Permiso permiso;

    @Column(name = "FK_ROL_ID")
    @JsonIgnore
    private Integer fkRolId;
}

@Data
@Entity
@Table(name = "PERMISO")
class Permiso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_PERMISO_ID ")
    private Integer pkPermisoId;

    @Column(name = "NOMBRE_PERMISO")
    private String nombrePermiso;

    @Column(name = "DESCRIPCION_PERMISO")
    private String descripcionPermiso;
}
