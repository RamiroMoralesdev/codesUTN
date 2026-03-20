import { getSessionUser } from "./storage";
import {
  goToLogin,
  goToRoleHome,
  isInAdminArea,
  isInAppEntry,
  isInAuthArea,
  isInClientArea,
} from "./navigation";

export function applyRouteGuard(pathname: string): void {
  const sessionUser = getSessionUser();
  const inAdmin = isInAdminArea(pathname);
  const inClient = isInClientArea(pathname);
  const inAuth = isInAuthArea(pathname);
  const inAppEntry = isInAppEntry(pathname);

  if (!sessionUser && (inAdmin || inClient || inAppEntry)) {
    goToLogin();
    return;
  }

  if (!sessionUser) {
    return;
  }

  if (inAuth || inAppEntry) {
    goToRoleHome(sessionUser.rol);
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
