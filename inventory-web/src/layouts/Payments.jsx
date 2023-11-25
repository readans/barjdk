import { useState } from "react";
import { usePagoStore, usePedidoStore } from "../store/store";
import Modal from "../components/Modal";
import { encrypt } from "../services/cipher";

function Payments() {
  const pagos = usePagoStore((state) => state.pagos);
  const pedidos = usePedidoStore((state) => state.pedidos);

  const { getPedidos } = usePedidoStore();
  const { getPagos } = usePagoStore();

  const [selectedOrder, setSelectedOrder] = useState(null);

  const [showModal, setShowModal] = useState(false);

  const handleSelectOrder = (order) => {
    setSelectedOrder((value) => {
      if (value === order) {
        return null;
      }
      return order;
    });
  };

  const handlePayOrder = () => {
    getPedidos();
    getPagos();
  };

  const payOrder = async () => {
    if (selectedOrder == null) return;
    const body = await encrypt({
      fkPedidoId: selectedOrder.pkPedidoId,
      valor: 5000,
    });
    fetch("http://localhost:8080/pago/guardar", {
      method: "POST",
      body: body,
    })
      .then((res) => res.text())
      .then((data) => {
        handlePayOrder();
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
                Realizar Pago
              </h2>
            </div>
            <div className="flex justify-center flex-grow overflow-y-auto">
              <div className="grid grid-cols-2 gap-2 mt-2 h-max">
                {pedidos.map((pedido) => (
                  <div
                    className="flex p-3 gap-x-2 items-center rounded-lg shadow-sm bg-white relative overflow-hidden select-none cursor-pointer"
                    key={`ped${pedido.pkPedidoId}`}
                    onClick={() => handleSelectOrder(pedido)}
                  >
                    {selectedOrder == pedido && (
                      <div className="absolute top-0 left-0 w-full h-full bg-black/25"></div>
                    )}
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
            <div className="flex justify-end">
              <button
                className="bg-blue-900 text-white inline-flex gap-x-2 rounded-full py-2 w-[100px] justify-center text-md"
                onClick={() => payOrder()}
              >
                Pagar
              </button>
            </div>
          </div>
        </Modal>
      )}
      <div className="flex justify-center">
        <div className="w-10/12 mb-6">
          <h1 className="text-3xl text-blue-900 font-semibold border-blue-900 border-b-2 mb-4 leading-relaxed">
            Pagos
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
            {pagos.map((pago) => (
              <div
                className="flex p-3 rounded-lg shadow-sm bg-white gap-x-2"
                key={`pay-${pago.pkPagoId}`}
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
                      d="M15.75 10.5V6a3.75 3.75 0 10-7.5 0v4.5m11.356-1.993l1.263 12c.07.665-.45 1.243-1.119 1.243H4.25a1.125 1.125 0 01-1.12-1.243l1.264-12A1.125 1.125 0 015.513 7.5h12.974c.576 0 1.059.435 1.119 1.007zM8.625 10.5a.375.375 0 11-.75 0 .375.375 0 01.75 0zm7.5 0a.375.375 0 11-.75 0 .375.375 0 01.75 0z"
                    />
                  </svg>
                </div>
                <div className="flex items-center flex-1">
                  <div className="w-full">
                    <h1 className="font-semibold text-xl">{pago.pkPagoId}</h1>
                    <div className="flex justify-between">
                      <p className="">{pago.valor}</p>
                      <span
                        className="bg-yellow-600
                        px-4 py-1 text-white rounded-full text-sm"
                      >
                        Pedido: {pago.fkPedidoId}
                      </span>
                    </div>
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

export default Payments;
