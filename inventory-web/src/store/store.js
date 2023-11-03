import { create } from "zustand";

export const useProductoStore = create((set) => ({
  productos: [],
  getProductos: async () => {
    const response = await fetch("http://localhost:8080/producto/consultar")
    const productos = await response.json();
    set(state => ({
      productos
    }))
  },
}));

export const useMesaStore = create((set) => ({
  mesas: [],
  getMesas: async () => {
    const response = await fetch("http://localhost:8080/mesa/consultar")
    const mesas = await response.json();
    set(state => ({
      mesas
    }))
  },
}))