import { getSessionUser } from "./storage";
import { goToLogin, goToRoleHome, isInAdminArea, isInClientArea } from "./navigation";

export function applyRouteGuard(pathname: string): void {
  const sessionUser = getSessionUser();
  const inAdmin = isInAdminArea(pathname);
  const inClient = isInClientArea(pathname);

  if ((inAdmin || inClient) && !sessionUser) {
    goToLogin();
    return;
  }

  if (!sessionUser) {
    return;
  }

  if (inAdmin && sessionUser.rol === "client") {
    goToRoleHome("client");
    return;
  }

  if (inClient && sessionUser.rol === "admin") {
    goToRoleHome("admin");
  }
}
