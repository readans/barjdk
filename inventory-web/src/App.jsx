import {
  BrowserRouter,
  Navigate,
  Outlet,
  Route,
  Routes,
  useRoutes,
} from "react-router-dom";
import { useEffect, useState } from "react";
import Login from "./layouts/Login";
import Home from "./layouts/Home";
import Dashboard from "./layouts/Dashboard";
import Order from "./layouts/Order";
import Payments from "./layouts/Payments";
import { useUserStore } from "./store/store";

function ProtectedRoute({ isAllowed, children, redirectTo }) {
  return !isAllowed ? <Navigate to={redirectTo} /> : children ?? <Outlet />;
}

function App() {
  const { setUser } = useUserStore();
  const user = useUserStore((state) => state.user);

  const login = (user) => setUser(user);
  const logout = () => setUser(null);

  return (
    <BrowserRouter>
      <Routes>
        <Route
          element={
            <ProtectedRoute
              isAllowed={user !== null}
              redirectTo={"/login"}
            ></ProtectedRoute>
          }
        >
          <Route path="/" element={<Dashboard user={user} onLogout={logout} />}>
            <Route path="" element={<Home />} />
            <Route
              path="orders"
              element={
                <ProtectedRoute
                  isAllowed={
                    !!user &&
                    user.rol.permisos.some(
                      (permiso) => permiso.permiso.pkPermisoId === 1
                    )
                  }
                  redirectTo={"/"}
                >
                  <Order />
                </ProtectedRoute>
              }
            />
            <Route
              path="payments"
              element={
                <ProtectedRoute
                  isAllowed={
                    !!user &&
                    user.rol.permisos.some(
                      (permiso) => permiso.permiso.pkPermisoId === 2
                    )
                  }
                  redirectTo={"/"}
                >
                  <Payments />
                </ProtectedRoute>
              }
            />
          </Route>
        </Route>
        <Route
          path="/login"
          element={<Login isAuthenticated={user !== null} onLogin={login} />}
        />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
