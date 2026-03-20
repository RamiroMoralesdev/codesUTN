async function obtenerDatos() {
  try {
    const response = await fetch("./data.json");

    if (!response.ok) {
      throw new Error("Error al cargar los datos");
    }

    const data = await response.json();

    categorias = data.categorias;
    productos = data.productos;

    cargarCategorias();
    cargarProductos();

  } catch (error) {
    console.error("Error:", error);
  }
}

// CARGAR CATEGORIAS
function cargarCategorias() {
  const lista = document.getElementById("lista-categorias");

  lista.innerHTML = "";

  categorias.forEach(c => {
    const li = document.createElement("li");

    li.innerHTML = `<a href="#">${c}</a>`;

    lista.appendChild(li);
  });
}

// CARGAR PRODUCTOS
function cargarProductos() {
  const contenedor = document.getElementById("contenedor-productos");

  contenedor.innerHTML = "";

  productos.forEach(p => {
    const article = document.createElement("article");

    article.innerHTML = `
      <img src="${p.imagen}" alt="${p.nombre}" width="150">
      <h3>${p.nombre}</h3>
      <p>${p.descripcion}</p>
      <p><strong>$${p.precio}</strong></p>
      <button onclick="agregarProducto('${p.nombre}')">Agregar</button>
    `;

    contenedor.appendChild(article);
  });
}

// INICIO
obtenerDatos();