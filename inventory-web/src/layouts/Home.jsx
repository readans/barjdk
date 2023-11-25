import { useEffect, useState } from "react";
import { useProductoStore, useMesaStore } from "../store/store";
import { encrypt } from "../services/cipher";

function Home() {
  const productos = useProductoStore((state) => state.productos);
  const mesas = useMesaStore((state) => state.mesas);
  const { setMesas } = useMesaStore();
  const [selectOpt, setSelectOpt] = useState("productos");

  const switchMesaState = async (updatedMesa) => {
    const body = await encrypt(updatedMesa);
    fetch("http://localhost:8080/mesa/guardar", {
      method: "POST",
      body: body,
    })
      .then((res) => res.text())
      .then((data) => null);
    const updatedMesas = mesas.map((mesa) => {
      if (mesa.pkMesaId == updatedMesa.pkMesaId) {
        return updatedMesa;
      }
      return mesa;
    });
    setMesas(updatedMesas);
  };

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
                          producto.cantidad > 0 ? "bg-green-600" : "bg-red-600"
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
                          d="M20.25 7.5l-.625 10.632a2.25 2.25 0 01-2.247 2.118H6.622a2.25 2.25 0 01-2.247-2.118L3.75 7.5M10 11.25h4M3.375 7.5h17.25c.621 0 1.125-.504 1.125-1.125v-1.5c0-.621-.504-1.125-1.125-1.125H3.375c-.621 0-1.125.504-1.125 1.125v1.5c0 .621.504 1.125 1.125 1.125z"
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
                    <div className="inline-flex items-center flex-col">
                      <div className="relative inline-block h-4 w-8 cursor-pointer rounded-full bg-slate-50">
                        <input
                          id={`switch-${mesa.pkMesaId}`}
                          type="checkbox"
                          className="peer absolute h-4 w-8 cursor-pointer appearance-none rounded-full bg-blue-gray-100 transition-colors duration-300 checked:bg-green-600 peer-checked:border-green-600 peer-checked:before:bg-green-600"
                          checked={mesa.estado == 1}
                          onChange={() =>
                            switchMesaState({
                              ...mesa,
                              estado: mesa.estado == 1 ? 2 : 1,
                            })
                          }
                        />
                        <label
                          htmlFor={`switch-${mesa.pkMesaId}`}
                          className="before:content[''] absolute top-2/4 -left-1 h-5 w-5 -translate-y-2/4 cursor-pointer rounded-full border border-blue-gray-100 bg-white shadow-md transition-all duration-300 before:absolute before:top-2/4 before:left-2/4 before:block before:h-10 before:w-10 before:-translate-y-2/4 before:-translate-x-2/4 before:rounded-full before:bg-blue-gray-500 before:opacity-0 before:transition-opacity hover:before:opacity-10 peer-checked:translate-x-full peer-checked:border-green-600 peer-checked:before:bg-green-600"
                        >
                          <div
                            className="top-2/4 left-2/4 inline-block -translate-x-2/4 -translate-y-2/4 rounded-full p-5"
                            data-ripple-dark="true"
                          ></div>
                        </label>
                      </div>
                      <span
                        className={`${mesa.estado == 1 && "text-green-600"}`}
                      >
                        {mesa.estado == 1 ? "Disponible" : "Ocupada"}
                      </span>
                    </div>
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
