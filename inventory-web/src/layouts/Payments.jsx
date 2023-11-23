import { usePagoStore } from "../store/store";

function Payments() {
  const pagos = usePagoStore((state) => state.pagos);
  console.log(pagos);

  return (
    <>
      <div className="flex justify-center">
        <div className="w-10/12 mb-6">
          <h1 className="text-3xl text-blue-900 font-semibold border-blue-900 border-b-2 mb-4 leading-relaxed">
            Pagos
          </h1>
          <div className="grid grid-cols-2 gap-2 mt-4">
            {pagos.map((pago) => (
              <div
                className="flex p-3 rounded-lg shadow-sm bg-white gap-x-2"
                key={`pay${pago.pkPagoId}`}
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
                      d="M21 7.5l-9-5.25L3 7.5m18 0l-9 5.25m9-5.25v9l-9 5.25M3 7.5l9 5.25M3 7.5v9l9 5.25m0-9v9"
                    />
                  </svg>
                </div>
                <div className="flex items-center flex-1">
                  <div className="w-full">
                    <h1 className="font-semibold text-xl">{pago.pkPagoId}</h1>
                    <div className="w-10/12 flex justify-between">
                      <p className="">{pago.valor}</p>
                      <p>pedido: {pago.fkPedidoId}</p>
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
