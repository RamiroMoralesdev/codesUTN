import { goToLogin } from "../../utils/navigation";
import { clearSession, getSessionUser } from "../../utils/storage";

const user = getSessionUser();
const welcome = document.getElementById("welcome") as HTMLParagraphElement | null;
const logoutButton = document.getElementById("logout-btn") as HTMLButtonElement | null;

if (welcome && user) {
  welcome.textContent = `Bienvenido ${user.email}. Tu rol es ${user.rol}.`;
}

if (logoutButton) {
  logoutButton.addEventListener("click", () => {
    clearSession();
    goToLogin();
  });
}
