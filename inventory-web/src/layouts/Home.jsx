import { NavLink } from "react-router-dom";
import Card from "../components/Card";
import { useEffect, useState } from "react";

function Home() {
  const [productos, setProductos] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/producto/consultar")
      .then((res) => res.json())
      .then((data) => console.log(data));
  }, []);

  return (
    <div className="flex justify-center">
      <div className="w-11/12">
        <div className="flex gap-x-2 overflow-y-auto border-blue-900 border-b-2">
          <NavLink
            to={""}
            className={({ isActive }) =>
              `${
                isActive ? "bg-blue-900 text-white" : "bg-white text-stone-800"
              } w-[200px] flex items-center justify-center h-10 rounded-t-xl`
            }
          >
            Productos
          </NavLink>
          <NavLink
            to={"mesas"}
            className={({ isActive }) =>
              `${
                isActive ? "bg-blue-900 text-white" : "bg-white text-stone-800"
              } w-[200px] flex items-center justify-center h-10 rounded-t-xl`
            }
          >
            Mesas
          </NavLink>
        </div>
        <div className="grid grid-cols-2 gap-2 mt-4">
          {productos.map((producto) => (
            <Card
              item={{
                title: producto.pkPagoId,
                description: producto.descripcion,
                qty: producto.cantidad,
                state: producto.valor,
              }}
            />
          ))}
        </div>
      </div>
    </div>
  );
}

export default Home;
