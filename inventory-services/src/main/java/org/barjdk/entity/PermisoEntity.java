package org.barjdk.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PERMISO")
public class PermisoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_PERMISO_ID ")
    private Integer pkPermisoId;

    @Column(name = "NOMBRE_PERMISO")
    private String nombrePermiso;

    @Column(name = "DESCRIPCION_PERMISO")
    private String descripcionPermiso;
}
