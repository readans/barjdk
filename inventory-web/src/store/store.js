import { create } from "zustand";

export const useProductoStore = create((set) => ({
  productos: [],
  getProductos: async () => {
    const response = await fetch("http://localhost:8080/producto/consultarTodos")
    const productos = await response.json();
    set(state => ({
      productos
    }))
  },
}));

export const useMesaStore = create((set) => ({
  mesas: [],
  getMesas: async () => {
    const response = await fetch("http://localhost:8080/mesa/consultarTodos")
    const mesas = await response.json();
    set(state => ({
      mesas
    }))
  },
}))

export const usePedidoStore = create((set) => ({
  pedidos: [],
  getPedidos: async () => {
    const response = await fetch("http://localhost:8080/pedido/consultarTodos")
    const pedidos = await response.json();
    console.log(pedidos)
    set(state => ({
      pedidos
    }))
  },
}))

export const usePagoStore = create((set) => ({
  pagos: [],
  getPagos: async () => {
    const response = await fetch("http://localhost:8080/pago/consultarTodos")
    const pagos = await response.json();
    set(state => ({
      pagos
    }))
  },
}))