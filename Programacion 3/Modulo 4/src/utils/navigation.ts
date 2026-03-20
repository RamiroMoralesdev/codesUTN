import type { Rol } from "../types/user";

function getAppBasePath(pathname: string): string {
  const pagesMarker = "/pages/";
  const pagesIndex = pathname.indexOf(pagesMarker);

  if (pagesIndex !== -1) {
    return `${pathname.slice(0, pagesIndex) || "/"}`;
  }

  const marker = "/src/";
  const currentPath = window.location.pathname;
  const srcIndex = currentPath.indexOf(marker);

  if (srcIndex === -1) {
    return "/";
  }

  return currentPath.slice(0, srcIndex + marker.length);
}

function resolveAppUrl(relativePath: string): string {
  const basePath = getAppBasePath(window.location.pathname);
  const cleanBase = basePath.endsWith("/") ? basePath : `${basePath}/`;
  const cleanRelative = relativePath.replace(/^\/+/, "");
  return `${cleanBase}${cleanRelative}`;
}

function navigateTo(relativePath: string): void {
  const targetPath = resolveAppUrl(relativePath);

  if (window.location.pathname === targetPath) {
    return;
  }

  window.location.href = targetPath;
}

export function goToLogin(): void {
  navigateTo("pages/auth/login/index.html");
}

export function goToRoleHome(rol: Rol): void {
  if (rol === "admin") {
    navigateTo("pages/admin/index.html");
    return;
  }

  navigateTo("pages/client/index.html");
}

export function isInAdminArea(pathname: string): boolean {
  return pathname.includes("/pages/admin/");
}

export function isInClientArea(pathname: string): boolean {
  return pathname.includes("/pages/client/");
}
