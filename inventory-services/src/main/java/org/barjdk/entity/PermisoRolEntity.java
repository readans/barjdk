package org.barjdk.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PERMISO_ROL")
public class PermisoRolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_PERMISO_ROL_ID ")
    private Integer pkPermisoRolId;

    @ManyToOne
    @JoinColumn(name = "FK_PERMISO_ID")
    private PermisoEntity permiso;

    @ManyToOne
    @JoinColumn(name = "FK_ROL_ID")
    private RolEntity rol;
}
