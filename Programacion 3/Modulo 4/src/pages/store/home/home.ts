import { PRODUCTS } from "../../../data/data";
import { goToLogin } from "../../../utils/navigation";
import { addProductToCart, clearSession, getCart } from "../../../utils/storage";

const catalogList = document.getElementById("catalog-list") as HTMLDivElement | null;
const cartCount = document.getElementById("cart-count") as HTMLSpanElement | null;
const logoutButton = document.getElementById("logout-btn") as HTMLButtonElement | null;
const searchInput = document.getElementById("search-input") as HTMLInputElement | null;
const categoryFilter = document.getElementById("category-filter") as HTMLSelectElement | null;

// Estado de filtros
let currentSearchTerm = "";
let currentCategoryId = "";

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

	const totalItems = getCart().reduce((acc, item) => acc + item.quantity, 0);
	cartCount.textContent = String(totalItems);
}

function initializeCategoryFilter(): void {
	if (!categoryFilter) {
		return;
	}

	// Obtener todas las categorías únicas de los productos disponibles
	const allCategories = new Map();
	PRODUCTS.filter((product) => product.disponible && !product.eliminado).forEach((product) => {
		product.categorias.forEach((cat) => {
			if (!allCategories.has(cat.id)) {
				allCategories.set(cat.id, cat);
			}
		});
	});

	// Agregar opciones al select
	allCategories.forEach((category) => {
		const option = document.createElement("option");
		option.value = String(category.id);
		option.textContent = category.nombre;
		categoryFilter.appendChild(option);
	});
}

function getFilteredProducts() {
	let filtered = PRODUCTS.filter((product) => product.disponible && !product.eliminado);

	// Filtrar por búsqueda
	if (currentSearchTerm) {
		filtered = filtered.filter((product) =>
			product.nombre.toLowerCase().includes(currentSearchTerm.toLowerCase()),
		);
	}

	// Filtrar por categoría
	if (currentCategoryId) {
		filtered = filtered.filter((product) =>
			product.categorias.some((cat) => String(cat.id) === currentCategoryId),
		);
	}

	return filtered;
}

function renderCatalog(): void {
	if (!catalogList) {
		return;
	}

	const filteredProducts = getFilteredProducts();

	if (filteredProducts.length === 0) {
		catalogList.innerHTML = "<p>No hay productos que coincidan con los filtros.</p>";
		return;
	}

	catalogList.innerHTML = filteredProducts
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

// Event listeners para búsqueda y filtro
if (searchInput) {
	searchInput.addEventListener("input", (e) => {
		currentSearchTerm = (e.target as HTMLInputElement).value;
		renderCatalog();
	});
}

if (categoryFilter) {
	categoryFilter.addEventListener("change", (e) => {
		currentCategoryId = (e.target as HTMLSelectElement).value;
		renderCatalog();
	});
}

// Inicializar
initializeCategoryFilter();
renderCatalog();
renderCartCount();

if (logoutButton) {
	logoutButton.addEventListener("click", () => {
		clearSession();
		goToLogin();
	});
}
