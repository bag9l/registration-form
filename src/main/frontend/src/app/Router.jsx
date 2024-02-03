import { Navigate, Route, Routes } from "react-router-dom";
import AuthFormLayout from "../layouts/AuthFormLayout";
import { MAIN_ROUTE, REGISTER_ROUTE } from "./Routes";
import RegisterRoute from "../routes/RegisterRoute";

const Router = () => {
  return (
    <Routes>
      <Route path={MAIN_ROUTE} element={<AuthFormLayout />}>
        <Route index element={<Navigate to={REGISTER_ROUTE} replace />} />
        <Route path={REGISTER_ROUTE} element={<RegisterRoute />} />
      </Route>
    </Routes>
  );
};

export default Router;
