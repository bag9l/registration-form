import { Stack } from "@mui/material";
import { Outlet } from "react-router-dom";

const AuthFormLayout = () => {
  return (
    <Stack
      alignItems="center"
      justifyContent="center"
      sx={{ width: "100%", height: "100vh" }}
    >
      <Outlet />
    </Stack>
  );
};

export default AuthFormLayout;
