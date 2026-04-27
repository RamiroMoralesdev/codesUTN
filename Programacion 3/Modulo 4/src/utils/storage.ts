import type { IUser } from "../types/user";
import type { CartItem } from "../types/product";

const USERS_KEY = "users";
const SESSION_KEY = "userData";
const CART_KEY = "cart";
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

export function getCart(): CartItem[] {
  const json = localStorage.getItem(CART_KEY);

  if (!json) {
    return [];
  }

  try {
    const parsed = JSON.parse(json) as CartItem[];

    if (!Array.isArray(parsed)) {
      return [];
    }

    return parsed.filter((item) => item.quantity > 0);
  } catch {
    return [];
  }
}

export function saveCart(items: CartItem[]): void {
  localStorage.setItem(CART_KEY, JSON.stringify(items));
}

export function addProductToCart(productId: number, quantity = 1): void {
  if (quantity <= 0) {
    return;
  }

  const cart = getCart();
  const existingItem = cart.find((item) => item.productId === productId);

  if (existingItem) {
    existingItem.quantity += quantity;
  } else {
    cart.push({ productId, quantity });
  }

  saveCart(cart);
}

export function clearCart(): void {
  localStorage.removeItem(CART_KEY);
}
