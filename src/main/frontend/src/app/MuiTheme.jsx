import * as React from "react";
import { ThemeProvider, CssBaseline, createTheme } from "@mui/material";
import "@fontsource/montserrat";

export const theme = createTheme({
  palette: {
    mode: "light",
    primary: {
      main: "#000000",
    },
  },
  typography: {
    fontFamily: "Montserrat",
  },
  components: {
    MuiCssBaseline: {
      styleOverrides: {
        "#root": {
          width: "100%",
          height: "100vh",
        },
      },
    },
    MuiOutlinedInput: {
      styleOverrides: {
        notchedOutline: {
          border: "0.5px solid",
        },
      },
    },
    MuiButton: {
      defaultProps: {
        disableElevation: true,
      },
    },
    MuiCheckbox: {
      defaultProps: {
        disableRipple: true,
      },
    },
  },
  spacing: 4,
  shape: {
    borderRadius: 8,
    containerBorderRadius: 0,
  },
});

const MuiTheme = ({ children }) => {
  return (
    <ThemeProvider theme={theme}>
      <CssBaseline />
      {children}
    </ThemeProvider>
  );
};

export default MuiTheme;
