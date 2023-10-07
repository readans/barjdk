import Card from "../components/Card";
import { useEffect, useState } from "react";
import Alert from "../components/Alert";

function Home() {
  const [productos, setProductos] = useState([]);
  const [mesas, setMesas] = useState([]);
  const [selectOpt, setSelectOpt] = useState("productos");

  useEffect(() => {
    fetch("http://localhost:8080/producto/consultar")
      .then((res) => res.json())
      .then((data) => setProductos(data));

    fetch("http://localhost:8080/mesa/consultar")
      .then((res) => res.json())
      .then((data) => setMesas(data));
  }, []);

  return (
    <div className="flex justify-center">
      <div className="w-11/12">
        <ul className="flex gap-x-2 overflow-y-auto border-blue-900 border-b-2">
          <li
            className={`${
              selectOpt == "productos"
                ? "bg-blue-900 text-white"
                : "bg-white text-stone-800"
            } w-[200px] flex items-center justify-center h-10 rounded-t-xl cursor-pointer`}
            onClick={() => setSelectOpt("productos")}
          >
            Productos
          </li>
          <li
            className={`${
              selectOpt == "mesas"
                ? "bg-blue-900 text-white"
                : "bg-white text-stone-800"
            } w-[200px] flex items-center justify-center h-10 rounded-t-xl cursor-pointer`}
            onClick={() => setSelectOpt("mesas")}
          >
            Mesas
          </li>
        </ul>
        <div className="grid grid-cols-2 gap-2 mt-4">
          {selectOpt == "productos"
            ? productos.map((producto) => (
                <Card
                  key={producto.pkPagoId}
                  item={{
                    title: producto.descripcion,
                    description: producto.valor,
                    qty: producto.cantidad,
                    state: "Disponible",
                  }}
                />
              ))
            : mesas.map((mesa) => (
                <Card
                  key={mesa.Id}
                  item={{
                    title: `Mesa ${mesa.pkMesaId}`,
                    state: mesa.estado == 1 ? "Disponible" : "Ocupada",
                  }}
                />
              ))}
        </div>
      </div>
    </div>
  );
}

export default Home;
