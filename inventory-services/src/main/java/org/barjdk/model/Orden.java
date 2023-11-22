package org.barjdk.model;

import lombok.Data;

import java.util.List;

@Data
public class Orden {
    private Integer pkEmpleadoId;
    private Integer pkMesaId;
    private List<DetalleOrden> detalles;
}

@Data
class DetalleOrden {
    private Integer pkProductoId;
    private Integer cantidad;
}
