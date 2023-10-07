package org.barjdk.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ROL")
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ROL_ID ")
    private Integer pkRolId;

    @Column(name = "NOMBRE")
    private String nombre;
}

