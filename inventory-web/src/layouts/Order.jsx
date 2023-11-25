import { useEffect, useState } from "react";
import Modal from "../components/Modal";
import {
  useProductoStore,
  useMesaStore,
  usePedidoStore,
  useUserStore,
} from "../store/store";
import Count from "../components/Count";
import { encrypt } from "../services/cipher";

function Order() {
  const user = useUserStore((state) => state.user);
  const pedidos = usePedidoStore((state) => state.pedidos);
  const productos = useProductoStore((state) => state.productos);
  const mesas = useMesaStore((state) => state.mesas);
  const { getProductos } = useProductoStore();
  const { getMesas } = useMesaStore();
  const { getPedidos } = usePedidoStore();

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

  const handleCreateOrder = () => {
    getPedidos();
    getProductos();
    getMesas();
  };

  const createOrder = async () => {
    const productsToOrder = productos
      .filter((product) => product.solicitar > 0)
      .map(({ pkProductoId, solicitar }) => ({
        fkProductoId: pkProductoId,
        cantidad: solicitar,
      }));
    if (productsToOrder.length == 0 || mesaSel === null) return;

    const body = await encrypt({
      fkEmpleadoId: user.pkEmpleadoId,
      fkMesaId: mesaSel.pkMesaId,
      detalles: productsToOrder,
    });
    fetch("http://localhost:8080/pedido/generar", {
      method: "POST",
      body: body,
    })
      .then((res) => res.text())
      .then((data) => {
        handleCreateOrder();
        setShowModal(false);
      });
  };

  return (
    <>
      {showModal && (
        <Modal hideModal={() => setShowModal(false)}>
          <div className="flex px-3 pt-8 pb-2 flex-col gap-y-2 max-h-[550px]">
            <div className="">
              <h2 className="text-xl inline-block text-blue-900 font-semibold border-blue-900 border-b-2 mb-4 ml-4 leading-relaxed">
                Crear Pedido
              </h2>
            </div>
            <div className="flex gap-x-2 flex-grow overflow-y-auto overflow-x-hidden px-4">
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
                    <div className="">
                      <div className="flex items-center">
                        <Count
                          minValue={0}
                          maxValue={producto.cantidad}
                          onChange={(value) => {
                            producto.solicitar = value;
                          }}
                        />
                      </div>
                      <span className="text-sm">
                        Máximo: {producto.cantidad}
                      </span>
                    </div>
                  </div>
                ))}
              </div>
            </div>
            <div className="flex justify-end">
              <button
                className="bg-blue-900 text-white inline-flex gap-x-2 rounded-full py-2 px-3 text-md"
                onClick={() => createOrder()}
              >
                Crear
              </button>
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
          <div className="grid grid-cols-2 gap-2 mt-4">
            {pedidos.map((pedido) => (
              <div
                className="flex p-3 gap-x-3 items-center rounded-lg shadow-sm bg-white"
                key={`ped${pedido.pkPedidoId}`}
              >
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
                      d="M2.25 3h1.386c.51 0 .955.343 1.087.835l.383 1.437M7.5 14.25a3 3 0 00-3 3h15.75m-12.75-3h11.218c1.121-2.3 2.1-4.684 2.924-7.138a60.114 60.114 0 00-16.536-1.84M7.5 14.25L5.106 5.272M6 20.25a.75.75 0 11-1.5 0 .75.75 0 011.5 0zm12.75 0a.75.75 0 11-1.5 0 .75.75 0 011.5 0z"
                    />
                  </svg>
                </div>
                <div className="w-full">
                  <div className="flex items-center">
                    <h1 className="font-semibold text-xl">
                      {pedido.pkPedidoId}
                    </h1>
                  </div>
                  <div className="flex gap-x-2">
                    <span
                      className="bg-orange-600
                        px-4 py-1 text-white rounded-full text-sm"
                    >
                      Mesa: {pedido.fkMesaId}
                    </span>
                    <span
                      className="bg-green-600
                        px-4 py-1 text-white rounded-full text-sm"
                    >
                      Empleado: {pedido.fkEmpleadoId}
                    </span>
                  </div>
                </div>
              </div>
            ))}
          </div>
        </div>
      </div>
    </>
  );
}

export default Order;
