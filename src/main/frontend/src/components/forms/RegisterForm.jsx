import {
  Button,
  Checkbox,
  FormControl,
  FormControlLabel,
  FormHelperText,
  InputLabel,
  Link,
  MenuItem,
  Select,
  Stack,
  TextField,
  Typography,
} from "@mui/material";
import {Link as RouterLink} from "react-router-dom";
import {useForm} from "react-hook-form";
import {useState} from "react";
import userService from "../../services/UserService";
import {Sex} from "../../enums/Sex";

const RegisterForm = () => {
    const [isChecked, setIsChecked] = useState(false);

    const {
        register,
        handleSubmit,
        formState: {errors},
        reset,
    } = useForm({
        mode: "onSubmit",
    });

    const onSubmit = async (data) => {
        try {
            await userService.registerUser(data);
            reset();
        } catch (err) {
            console.error(err);
        }
    };

    return (
        <Stack
            component="form"
            onSubmit={handleSubmit(onSubmit)}
            maxWidth="sm"
            gap={4}
        >
            <Typography variant="h4" fontWeight="bold">
                Register form
            </Typography>
            <TextField
                label="First name"
                {...register("firstName", {
                    required: {
                        value: true,
                        message: "Field is required!",
                    },
                    minLength: {
                        value: 2,
                        message: "Min length is 2 symbols!",
                    },
                    maxLength: {
                        value: 30,
                        message: "Max length is 30 symbols!",
                    },
                })}
                helperText={errors?.firstName ? errors.firstName.message : " "}
                error={!!errors?.firstName}
            />
            <TextField
                label="Last name"
                {...register("lastName", {
                    required: {
                        value: true,
                        message: "Field is required!",
                    },
                    minLength: {
                        value: 2,
                        message: "Min length is 2 symbols!",
                    },
                    maxLength: {
                        value: 30,
                        message: "Max length is 30 symbols!",
                    },
                })}
                helperText={errors?.lastName ? errors.lastName.message : " "}
                error={!!errors?.lastName}
            />
            <TextField
                label="Phone number"
                {...register("phoneNumber", {
                    required: {
                        value: true,
                        message: "Field is required!",
                    },
                    minLength: {
                        value: 7,
                        message: "Min length is 7 symbols!",
                    },
                    maxLength: {
                        value: 10,
                        message: "Max length is 10 symbols!",
                    },
                    pattern: {
                        value: /^\d+$/,
                        message: "Enter a valid phone number (only numbers)!",
                    },
                })}
                helperText={errors?.number ? errors.number.message : " "}
                error={!!errors?.number}
            />
            <FormControl fullWidth error={!!errors?.sex}>
                <InputLabel id="sex-id">Sex</InputLabel>
                <Select
                    labelId="sex-id"
                    label="Sex"
                    {...register("sex", {
                        required: {
                            value: true,
                            message: "Field is required!",
                        },
                    })}
                    defaultValue={""}
                >
                    <MenuItem value={Sex.MALE}>Male</MenuItem>
                    <MenuItem value={Sex.FEMALE}>Female</MenuItem>
                </Select>
                <FormHelperText>
                    {errors?.sex ? errors.sex.message : " "}
                </FormHelperText>
            </FormControl>

            <Stack flexDirection="row" alignItems="center">
                <FormControlLabel
                    control={
                        <Checkbox
                            {...register("agreeTermsOfUse", {
                                required: {
                                    value: true,
                                    message: "You must agree to the terms of use!",
                                },
                            })}
                            onChange={(e) => setIsChecked(e.target.checked)}
                        />
                    }
                    label={
                        <Typography variant="p" sx={{width: "fit-content"}}>
                            By registering, you agree to the{" "}
                            <Link to={"#"} component={RouterLink}>
                                terms of use{" "}
                            </Link>
                        </Typography>
                    }
                />
            </Stack>

            <Button variant="contained" type="submit" disabled={!isChecked}>
                Create Account
            </Button>
        </Stack>
    );
};

export default RegisterForm;
