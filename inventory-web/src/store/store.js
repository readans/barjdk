import { create } from "zustand";
import { encrypt, decrypt } from "../services/cipher.js";

export const useUserStore = create((set) => ({
  user: JSON.parse(localStorage.getItem("user")),
  setUser: (user) => {
    user !== null ? localStorage.setItem("user", JSON.stringify(user)) : localStorage.removeItem("user");
    set((state) => ({ user }))
  }
}))

export const useProductoStore = create((set) => ({
  productos: [],
  getProductos: async () => {
    const response = await fetch("http://localhost:8080/producto/consultarTodos")
    const productos = await response.text();
    set(state => ({
      productos: decrypt(productos).productos
    }))
  },
}));

export const useMesaStore = create((set) => ({
  mesas: [],
  getMesas: async () => {
    const response = await fetch("http://localhost:8080/mesa/consultarTodos")
    const mesas = await response.text();
    set(state => ({
      mesas: decrypt(mesas).mesas
    }))
  },
  setMesas: (mesas) => set((state) => ({ mesas }))
}))

export const usePedidoStore = create((set) => ({
  pedidos: [],
  getPedidos: async () => {
    const response = await fetch("http://localhost:8080/pedido/consultarTodos")
    const pedidos = await response.text();
    set(state => ({
      pedidos: decrypt(pedidos).pedidos
    }))
  },
}))

export const usePagoStore = create((set) => ({
  pagos: [],
  getPagos: async () => {
    const response = await fetch("http://localhost:8080/pago/consultarTodos")
    const pagos = await response.text();
    set(state => ({
      pagos: decrypt(pagos).pagos
    }))
  },
}))