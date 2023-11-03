import { useEffect, useState } from "react";
import Modal from "../components/Modal";
import { useProductoStore, useMesaStore } from "../store/store";

function Order() {
  const productos = useProductoStore((state) => state.productos);
  const mesas = useMesaStore((state) => state.mesas);

  const [productosDisp, setProductosDisp] = useState([]);
  useEffect(() => {
    setProductosDisp(productos.filter((pro) => pro.cantidad > 0));
  }, [productos]);

  const [mesasDisp, setMesasDisp] = useState([]);
  useEffect(() => {
    setMesasDisp(mesas.filter((mesa) => mesa.estado == 1));
  }, [mesas]);

  const [showModal, setShowModal] = useState(false);

  const [mesaSel, setMesaSel] = useState(null);

  return (
    <>
      {showModal && (
        <Modal hideModal={() => setShowModal(false)}>
          <div className="px-10 pt-14 flex gap-x-2">
            <div className="w-6/12">
              <h4 className="font-medium text-xl mb-2">Mesa</h4>
              {mesasDisp.map((mesa) => (
                <div
                  className="bg-white relative flex p-3 rounded-lg shadow-sm cursor-pointer overflow-hidden mb-2"
                  onClick={() =>
                    setMesaSel((mesaSel) => (mesaSel != mesa ? mesa : null))
                  }
                  key={mesa.pkMesaId}
                >
                  {mesaSel == mesa && (
                    <div className="absolute top-0 left-0 w-full h-full bg-black/25"></div>
                  )}
                  <div className="flex flex-grow gap-x-3">
                    <div className="h-14 aspect-square bg-blue-900 rounded-md grid place-items-center text-white">
                      <svg
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 24 24"
                        strokeWidth={1.5}
                        stroke="currentColor"
                        className="w-8"
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
                </div>
              ))}
            </div>
            <div className="w-6/12">
              <h4 className="font-medium text-xl mb-2">Productos</h4>
              {productosDisp.map((producto) => (
                <div
                  className="flex p-3 rounded-lg shadow-sm bg-white mb-2"
                  key={`pro${producto.pkProductoId}`}
                >
                  <div className="flex flex-grow gap-x-3">
                    <div className="h-14 aspect-square bg-blue-900 rounded-md grid place-items-center text-white">
                      <svg
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 24 24"
                        strokeWidth={1.5}
                        stroke="currentColor"
                        className="w-8"
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
                        <h1 className="font-semibold text-lg">
                          {producto.descripcion}
                        </h1>
                        <p className="text-base">{producto.valor}</p>
                      </div>
                    </div>
                  </div>
                  <div className="flex items-center"></div>
                </div>
              ))}
            </div>
          </div>
        </Modal>
      )}
      <div className="flex justify-center">
        <div className="w-10/12 mb-6">
          <h1 className="text-3xl text-blue-900 font-semibold border-blue-900 border-b-2 mb-4 leading-relaxed">
            Pedidos
          </h1>
          <div className="flex justify-end">
            <button
              className="bg-blue-900 text-white inline-flex gap-x-2 rounded-full py-3 px-5"
              onClick={() => setShowModal(true)}
            >
              Crear
              <svg
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                strokeWidth="1.5"
                stroke="currentColor"
                className="w-6 h-6"
              >
                <path
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  d="M12 4.5v15m7.5-7.5h-15"
                />
              </svg>
            </button>
          </div>
        </div>
      </div>
    </>
  );
}

export default Order;
