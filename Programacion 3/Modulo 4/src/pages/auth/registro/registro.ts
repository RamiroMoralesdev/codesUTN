import type { IUser } from "../../../types/user";
import { getUsers, saveUsers } from "../../../utils/storage";
import { goToLogin } from "../../../utils/navigation";

const form = document.getElementById("registro-form") as HTMLFormElement | null;

if (form) {
  form.addEventListener("submit", (event) => {
    event.preventDefault();

    const emailInput = document.getElementById("email") as HTMLInputElement;
    const passwordInput = document.getElementById("password") as HTMLInputElement;

    const email = emailInput.value.trim().toLowerCase();
    const password = passwordInput.value.trim();

    if (!email || !password) {
      alert("Debes completar email y contrasena.");
      return;
    }

    const users = getUsers();
    const alreadyExists = users.some((user) => user.email === email);

    if (alreadyExists) {
      alert("El email ya esta registrado.");
      return;
    }

    const newUser: IUser = {
      email,
      password,
      rol: "client",
    };

    users.push(newUser);
    saveUsers(users);

    alert("Registro exitoso. Ahora puedes iniciar sesion.");
    form.reset();
    goToLogin();
  });
}
