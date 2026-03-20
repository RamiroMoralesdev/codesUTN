import { applyRouteGuard } from "./utils/guard";

function bootstrap(): void {
  applyRouteGuard(window.location.pathname); // Le paso como parametro el path de la ruta actual 
}

window.addEventListener("DOMContentLoaded", bootstrap);
