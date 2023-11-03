import { useEffect, useState } from "react";
import { useProductoStore, useMesaStore } from "../store/store";

function Home() {
  const productos = useProductoStore((state) => state.productos);
  const mesas = useMesaStore((state) => state.mesas);
  const [selectOpt, setSelectOpt] = useState("productos");
  console.log(productos);

  return (
    <div className="flex justify-center">
      <div className="w-10/12 mb-6">
        <ul className="inline-flex relative overflow-y-auto border-blue-900  after:absolute after:bottom-0 after:left-0 after:h-[2px] after:bg-gray-200 after:w-full">
          <li
            className={`${
              selectOpt == "productos"
                ? "after:absolute after:bottom-0 after:left-0 after:h-[3px] after:bg-blue-900 after:w-full text-black font-semibold after:z-10 "
                : "text-gray-300 hover:text-gray-400"
            } relative w-[200px] font-semibold flex items-center justify-center h-10 cursor-pointer  hover:bg-gray-200 transition-all`}
            onClick={() => setSelectOpt("productos")}
          >
            Productos
          </li>
          <li
            className={`${
              selectOpt == "mesas"
                ? "after:absolute after:bottom-0 after:left-0 after:h-[3px] after:bg-blue-900 after:w-full text-black font-semibold after:z-10"
                : "text-gray-300 hover:text-gray-400"
            } relative w-[200px] font-semibold flex items-center justify-center h-10 cursor-pointer hover:bg-gray-200 transition-all`}
            onClick={() => setSelectOpt("mesas")}
          >
            Mesas
          </li>
        </ul>
        <div className="grid grid-cols-2 gap-2 mt-4">
          {selectOpt === "productos"
            ? productos.map((producto) => (
                <div
                  className="flex p-3 rounded-lg shadow-sm bg-white"
                  key={`pro${producto.pkProductoId}`}
                >
                  <div className="flex flex-grow gap-x-3">
                    <div className="h-20 aspect-square bg-blue-900 rounded-md grid place-items-center text-white">
                      <svg
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 24 24"
                        strokeWidth={1.5}
                        stroke="currentColor"
                        className="w-10"
                      >
                        <path
                          strokeLinecap="round"
                          strokeLinejoin="round"
                          d="M21 7.5l-9-5.25L3 7.5m18 0l-9 5.25m9-5.25v9l-9 5.25M3 7.5l9 5.25M3 7.5v9l9 5.25m0-9v9"
                        />
                      </svg>
                    </div>
                    <div className="flex items-center">
                      <div className="">
                        <h1 className="font-semibold text-xl">
                          {producto.descripcion}
                        </h1>
                        <p className="">{producto.valor}</p>
                      </div>
                    </div>
                  </div>
                  <div className="flex items-center">
                    <div className="flex flex-col items-center">
                      <div className="flex gap-x-2 items-center">
                        <h2 className="text-2xl font-semibold">
                          {producto.cantidad}
                        </h2>
                        <h3>und</h3>
                      </div>
                      <span
                        className={`${
                          producto.cantidad > 0 ? "bg-green-600" : "bg-red-400"
                        } px-4 py-1 text-white rounded-full text-sm`}
                      >
                        {producto.cantidad > 0 ? "Disponible" : "Agotado"}
                      </span>
                    </div>
                  </div>
                </div>
              ))
            : selectOpt === "mesas"
            ? mesas.map((mesa) => (
                <div
                  className="flex p-3 rounded-lg shadow-sm bg-white"
                  key={`m${mesa.pkMesaId}`}
                >
                  <div className="flex flex-grow gap-x-3">
                    <div className="h-20 aspect-square bg-blue-900 rounded-md grid place-items-center text-white">
                      <svg
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 24 24"
                        strokeWidth={1.5}
                        stroke="currentColor"
                        className="w-10"
                      >
                        <path
                          strokeLinecap="round"
                          strokeLinejoin="round"
                          d="M21 7.5l-9-5.25L3 7.5m18 0l-9 5.25m9-5.25v9l-9 5.25M3 7.5l9 5.25M3 7.5v9l9 5.25m0-9v9"
                        />
                      </svg>
                    </div>
                    <div className="flex items-center">
                      <h1 className="font-semibold text-xl">
                        {String(mesa.pkMesaId).padStart(4, "0")}
                      </h1>
                    </div>
                  </div>
                  <div className="flex items-center">
                    <span
                      className={`${
                        mesa.estado == 1 ? "bg-green-600" : "bg-red-400"
                      } px-4 py-1 text-white rounded-full text-sm`}
                    >
                      {mesa.estado == 1 ? "Disponible" : "Ocupada"}
                    </span>
                  </div>
                </div>
              ))
            : hola}
        </div>
      </div>
    </div>
  );
}

export default Home;
