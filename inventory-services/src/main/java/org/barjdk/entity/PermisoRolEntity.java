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

    @Column(name = "FK_PERMISO_ID")
    private String fkPermisoId;

    @Column(name = "FK_ROL_ID")
    private String fkRolId;
}
