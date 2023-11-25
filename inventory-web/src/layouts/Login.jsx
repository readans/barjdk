import localforage from "localforage";
import { useEffect, useRef, useState } from "react";
import { Navigate } from "react-router-dom";
import Modal from "../components/Modal";
import Alert from "../components/Alert";
import { decrypt, encrypt } from "../services/cipher";

export default function Login({ isAuthenticated, onLogin }) {
  const username = useRef();
  const password = useRef();

  const [error, setError] = useState(false);

  const authUser = async (username, password) => {
    const body = await encrypt({
      usuarioAcceso: username,
      claveAcceso: password,
    });
    fetch("http://localhost:8080/empleado/validar", {
      method: "POST",
      body: body,
    })
      .then((res) => res.text())
      .then((data) => {
        const decrypted = decrypt(data);
        decrypted.pkEmpleadoId !== undefined
          ? onLogin(decrypted)
          : setError(true);
      })
      .catch((e) => setError(true));
  };

  const [modal, setModal] = useState({ type: "default", visible: false });

  return (
    <>
      {isAuthenticated && <Navigate to={"/"} />}
      {error && (
        <div className="absolute top-0 left-0 w-full flex justify-center mt-4 z-20">
          <Alert
            type={"info"}
            content={"Credenciales inválidas"}
            onClick={() => setError(false)}
          />
        </div>
      )}
      {modal.visible && (
        <Modal hideModal={() => setModal({ ...modal, visible: false })}>
          {modal.type == "help" ? (
            <h1>Hello, world!</h1>
          ) : modal.type == "password" ? (
            <div className="grid place-items-center h-[400px]">
              <div className="flex flex-col items-center gap-y-3 w-6/12">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 24 24"
                  strokeWidth={1.5}
                  stroke="currentColor"
                  className="w-14"
                >
                  <path
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    d="M9 3.75H6.912a2.25 2.25 0 00-2.15 1.588L2.35 13.177a2.25 2.25 0 00-.1.661V18a2.25 2.25 0 002.25 2.25h15A2.25 2.25 0 0021.75 18v-4.162c0-.224-.034-.447-.1-.661L19.24 5.338a2.25 2.25 0 00-2.15-1.588H15M2.25 13.5h3.86a2.25 2.25 0 012.012 1.244l.256.512a2.25 2.25 0 002.013 1.244h3.218a2.25 2.25 0 002.013-1.244l.256-.512a2.25 2.25 0 012.013-1.244h3.859M12 3v8.25m0 0l-3-3m3 3l3-3"
                  />
                </svg>
                <h2 className="font-semibold text-xl">Lorem, ipsum.</h2>
                <p className="text-center">
                  Lorem ipsum dolor sit amet consectetur adipisicing.
                </p>
                <div className="bg-neutral-100 h-12 w-full rounded-2xl px-3 flex items-center gap-x-2 mb-4">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    fill="none"
                    viewBox="0 0 24 24"
                    strokeWidth={1.5}
                    stroke="currentColor"
                    className="w-6 h-6"
                  >
                    <path
                      strokeLinecap="round"
                      d="M16.5 12a4.5 4.5 0 11-9 0 4.5 4.5 0 019 0zm0 0c0 1.657 1.007 3 2.25 3S21 13.657 21 12a9 9 0 10-2.636 6.364M16.5 12V8.25"
                    />
                  </svg>
                  <input
                    type="text"
                    name="email"
                    id=""
                    placeholder="email"
                    className="bg-transparent outline-none flex-1 text-stone-900"
                  />
                </div>
              </div>
            </div>
          ) : (
            <p>Nothing</p>
          )}
        </Modal>
      )}
      <div className="grid place-items-center min-h-screen">
        <div className="w-10/12 min-h-[90vh] bg-white rounded-xl shadow-lg flex overflow-hidden">
          <div className="w-1/2 flex justify-center pt-28 z-10">
            <div className="w-full max-w-[365px] flex flex-col items-center">
              <h1 className="font-bold text-2xl leading-8">LOGIN</h1>
              <p className="leading-8 mb-2">Accede a tu portal</p>
              <form onSubmit={(e) => e.preventDefault()} className="w-full">
                <div className="bg-neutral-100 h-12 w-full rounded-2xl px-3 flex items-center gap-x-2 mb-4">
                  <img
                    src="/src/assets/icons/user.svg"
                    alt=""
                    className="h-5"
                  />
                  <input
                    type="text"
                    name="username"
                    placeholder="username"
                    ref={username}
                    className="bg-transparent outline-none flex-1 text-stone-900"
                  />
                </div>

                <div className="bg-neutral-100 h-12 w-full rounded-2xl px-3 flex items-center gap-x-2">
                  <img
                    src="/src/assets/icons/lock.svg"
                    alt=""
                    className="h-5"
                  />
                  <input
                    type="password"
                    name="password"
                    placeholder="password"
                    ref={password}
                    className="bg-transparent outline-none flex-1 text-stone-900"
                  />
                </div>
                <div className="flex justify-center mt-4">
                  <button
                    type="submit"
                    className="bg-blue-800 hover:bg-blue-900 px-2 min-w-[100px] h-12 rounded-xl text-white select-none"
                    onClick={() =>
                      authUser(username.current.value, password.current.value)
                    }
                  >
                    Login
                  </button>
                </div>
              </form>
              <div className="w-full mt-4 flex justify-center"></div>
              <a
                className="text-blue-800  cursor-pointer hover:underline"
                onClick={() => setModal({ type: "password", visible: true })}
              >
                ¿Olvidaste tu contraseña?
              </a>
            </div>
          </div>
          <div className="w-1/2 bg-blue-900 relative flex justify-center items-center select-none">
            <img
              src="/src/assets/login-texture.png"
              alt=""
              className="absolute w-full h-full"
            />
            <div className="bg-glass w-6/12 h-[380px] bg-white/20 border-white/20 border flex items-end justify-end rounded-2xl backdrop-blur-2xl relative">
              <h2 className="absolute top-0 left-0 mt-2 ml-4 text-[40px] w-4/12 font-bold text-white">
                ¡Hola, ahí!
              </h2>
              <div
                className="absolute bottom-0 left-0 h-[42px] aspect-square rounded-full bg-white grid place-items-center -ml-[21px] cursor-pointer mb-10"
                onClick={() => setModal({ type: "help", visible: true })}
              >
                <img
                  src="/src/assets/thunderbolt.png"
                  alt=""
                  className="w-2/3"
                />
              </div>
              <img
                src="/src/assets/women-with-tab.png"
                alt=""
                className="aspect-[6/4] h-full max-w-none -mr-20"
              />
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
