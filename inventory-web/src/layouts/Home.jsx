import Card from "../components/Card";
import { useEffect, useState } from "react";

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
      <div className="w-10/12 mb-6">
        <ul className="inline-flex relative overflow-y-auto border-blue-900  after:absolute after:bottom-0 after:left-0 after:h-[2px] after:bg-gray-200 after:w-full">
          <li
            className={`${
              selectOpt == "productos"
                ? "after:absolute after:bottom-0 after:left-0 after:h-[3px] after:bg-blue-900 after:w-full text-black font-semibold after:z-10"
                : "text-gray-400"
            } relative w-[200px] font-semibold flex items-center justify-center h-10 cursor-pointer hover:bg-gray-200 transition-all`}
            onClick={() => setSelectOpt("productos")}
          >
            Productos
          </li>
          <li
            className={`${
              selectOpt == "mesas"
                ? "after:absolute after:bottom-0 after:left-0 after:h-[3px] after:bg-blue-900 after:w-full text-black font-semibold after:z-10"
                : "text-gray-400"
            } relative w-[200px] font-semibold flex items-center justify-center h-10 cursor-pointer hover:bg-gray-200 transition-all`}
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
                  }}
                  selectable={true}
                  onSelect={(item) => {
                    console.log(item);
                  }}
                >
                  <div className="flex items-center">
                    <div className="flex flex-col items-center">
                      <div className="flex gap-x-2 items-center">
                        <h2 className="text-2xl font-semibold">
                          {producto.cantidad}
                        </h2>
                        <h3>und</h3>
                      </div>
                      <span className="px-4 py-1 bg-gray-700 text-white rounded-full text-sm">
                        {producto.cantidad > 0 ? "Disponible" : "Agotado"}
                      </span>
                    </div>
                  </div>
                </Card>
              ))
            : mesas.map((mesa) => (
                <Card
                  key={mesa.pkMesaId}
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
