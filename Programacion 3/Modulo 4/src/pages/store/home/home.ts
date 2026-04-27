import { PRODUCTS } from "../../../data/data";
import { goToLogin } from "../../../utils/navigation";
import { addProductToCart, clearSession, getCart } from "../../../utils/storage";

const catalogList = document.getElementById("catalog-list") as HTMLDivElement | null;
const cartCount = document.getElementById("cart-count") as HTMLSpanElement | null;
const logoutButton = document.getElementById("logout-btn") as HTMLButtonElement | null;

function formatCurrency(value: number): string {
	return new Intl.NumberFormat("es-AR", {
		style: "currency",
		currency: "ARS",
		maximumFractionDigits: 0,
	}).format(value);
}

function renderCartCount(): void {
	if (!cartCount) {
		return;
	}

	const totalItems = getCart().reduce((acc, item) => acc + item.quantity, 0); // Itera sobre cada elemento, suma, y devuelve un unico valor 
	cartCount.textContent = String(totalItems);
}

function renderCatalog(): void {
	if (!catalogList) {
		return;
	}

	const availableProducts = PRODUCTS.filter((product) => product.disponible && !product.eliminado);

	if (availableProducts.length === 0) {
		catalogList.innerHTML = "<p>No hay productos disponibles.</p>";
		return;
	}

	catalogList.innerHTML = availableProducts
		.map(
			(product) => `
			<article class="product-item">
				<h3>${product.nombre}</h3>
				<p>${product.descripcion}</p>
				<p>Precio: <strong>${formatCurrency(product.precio)}</strong></p>
				<button type="button" data-product-id="${product.id}">Agregar</button>
			</article>
		`,
		)
		.join("");

	const addButtons = catalogList.querySelectorAll("button[data-product-id]");

	addButtons.forEach((button) => {
		button.addEventListener("click", () => {
			const productId = Number((button as HTMLButtonElement).dataset.productId);

			if (!productId) {
				return;
			}

			addProductToCart(productId, 1);
			renderCartCount();
			alert("Producto agregado al carrito.");
		});
	});
}

renderCatalog();
renderCartCount();

if (logoutButton) {
	logoutButton.addEventListener("click", () => {
		clearSession();
		goToLogin();
	});
}
