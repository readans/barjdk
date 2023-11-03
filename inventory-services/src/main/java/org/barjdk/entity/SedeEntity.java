package org.barjdk.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "SEDE")
public class SedeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_SEDE_ID ")
    private Integer pkSedeId;

    @Column(name = "DIRECCION_SEDE")
    private String direccionSede;
}


