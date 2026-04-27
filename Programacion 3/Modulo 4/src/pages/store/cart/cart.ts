import { PRODUCTS } from "../../../data/data";
import { goToLogin } from "../../../utils/navigation";
import { clearSession, getCart } from "../../../utils/storage";

const cartList = document.getElementById("cart-list") as HTMLDivElement | null;
const cartTotal = document.getElementById("cart-total") as HTMLParagraphElement | null;
const logoutButton = document.getElementById("logout-btn") as HTMLButtonElement | null;

function formatCurrency(value: number): string {
	return new Intl.NumberFormat("es-AR", {
		style: "currency",
		currency: "ARS",
		maximumFractionDigits: 0,
	}).format(value);
}

function renderCart(): void {
	if (!cartList || !cartTotal) {
		return;
	}

	const items = getCart();

	if (items.length === 0) {
		cartList.innerHTML = "<p>El carrito esta vacio.</p>";
		cartTotal.textContent = "Total: $ 0";
		return;
	}

	const rows = items
		.map((item) => {
			const product = PRODUCTS.find((p) => p.id === item.productId);

			if (!product) {
				return "";
			}

			const subtotal = product.precio * item.quantity;

			return `
			<article class="cart-item">
				<p><strong>${product.nombre}</strong></p>
				<p>Precio unitario: ${formatCurrency(product.precio)}</p>
				<p>Cantidad: ${item.quantity}</p>
				<p>Subtotal: ${formatCurrency(subtotal)}</p>
			</article>
		`;
		})
		.join("");

	const total = items.reduce((acc, item) => {
		const product = PRODUCTS.find((p) => p.id === item.productId);

		if (!product) {
			return acc;
		}

		return acc + product.precio * item.quantity;
	}, 0);

	cartList.innerHTML = rows;
	cartTotal.textContent = `Total: ${formatCurrency(total)}`;
}

renderCart();

if (logoutButton) {
	logoutButton.addEventListener("click", () => {
		clearSession();
		goToLogin();
	});
}
