import { goToRoleHome } from "../../../utils/navigation";
import { getUsers, setSessionUser } from "../../../utils/storage";

const form = document.getElementById("login-form") as HTMLFormElement | null;

if (form) {
  form.addEventListener("submit", (event) => {
    event.preventDefault();

    const emailInput = document.getElementById("email") as HTMLInputElement;
    const passwordInput = document.getElementById("password") as HTMLInputElement;

    const email = emailInput.value.trim().toLowerCase();
    const password = passwordInput.value.trim();

    const users = getUsers();

    const matchedUser = users.find(
      (user) => user.email === email && user.password === password,
    );

    if (!matchedUser) {
      alert("Credenciales incorrectas.");
      return;
    }

    setSessionUser(matchedUser);
    goToRoleHome(matchedUser.rol);
  });
}
