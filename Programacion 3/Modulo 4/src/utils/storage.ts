import type { IUser } from "../types/user";

const USERS_KEY = "users";
const SESSION_KEY = "userData";
const DEFAULT_USERS: IUser[] = [   // INTERFAZ 
  { email: "admin", password: "admin123", rol: "admin" },
];

function withDefaultUsers(users: IUser[]): IUser[] {
  const merged = [...users];

  for (const defaultUser of DEFAULT_USERS) {
    const exists = merged.some((user) => user.email === defaultUser.email);

    if (!exists) {
      merged.push(defaultUser);
    }
  }

  return merged;
}

export function getUsers(): IUser[] {
  const json = localStorage.getItem(USERS_KEY);

  if (!json) {
    saveUsers(DEFAULT_USERS);
    return [...DEFAULT_USERS];
  }

  try {
    const parsedUsers = JSON.parse(json) as IUser[];

    if (!Array.isArray(parsedUsers)) {
      saveUsers(DEFAULT_USERS);
      return [...DEFAULT_USERS];
    }

    const users = withDefaultUsers(parsedUsers);
    saveUsers(users);
    return users;
  } catch {
    saveUsers(DEFAULT_USERS);
    return [...DEFAULT_USERS];
  }
}

export function saveUsers(users: IUser[]): void {
  localStorage.setItem(USERS_KEY, JSON.stringify(users));
}

export function getSessionUser(): IUser | null {
  const json = localStorage.getItem(SESSION_KEY);

  if (!json) {
    return null;
  }

  try {
    return JSON.parse(json) as IUser;
  } catch {
    return null;
  }
}

export function setSessionUser(user: IUser): void {
  localStorage.setItem(SESSION_KEY, JSON.stringify(user));
}

export function clearSession(): void {
  localStorage.removeItem(SESSION_KEY);
}
