import {
  BrowserRouter,
  Navigate,
  Outlet,
  Route,
  Routes,
} from "react-router-dom";
import { useState } from "react";
import Login from "./layouts/Login";
import Home from "./layouts/Home";
import Dashboard from "./layouts/Dashboard";
import Order from "./layouts/Order";
import Payments from "./layouts/Payments";

function ProtectedRoute({ isAllowed, children, redirectTo }) {
  return !isAllowed ? <Navigate to={redirectTo} /> : children ?? <Outlet />;
}

function App() {
  const [user, setUser] = useState(JSON.parse(localStorage.getItem("user")));

  const login = (user) => {
    localStorage.setItem("user", JSON.stringify(user));
    setUser(user);
  };

  const logout = () => {
    localStorage.removeItem("user");
    setUser(null);
  };

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
                  isAllowed={!!user && user.permissions.includes("orders")}
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
                  isAllowed={!!user && user.permissions.includes("payments")}
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
