package org.barjdk.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "MESA")
public class MesaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_MESA_ID ")
    private Integer pkMesaId;

    @Column(name = "ESTADO")
    private Integer estado;
}



