import{a as e,i as t,n,o as r,p as i,s as a,t as o,u as s}from"../../../main-D2WXCwoL.js";/* empty css                      */import{n as c,t as l}from"../../../data-CTb6J966.js";var u=i((()=>{c(),t(),s();var i=document.getElementById(`catalog-list`),o=document.getElementById(`cart-count`),u=document.getElementById(`logout-btn`);function d(e){return new Intl.NumberFormat(`es-AR`,{style:`currency`,currency:`ARS`,maximumFractionDigits:0}).format(e)}function f(){if(!o)return;let e=a().reduce((e,t)=>e+t.quantity,0);o.textContent=String(e)}function p(){if(!i)return;let t=l.filter(e=>e.disponible&&!e.eliminado);if(t.length===0){i.innerHTML=`<p>No hay productos disponibles.</p>`;return}i.innerHTML=t.map(e=>`
			<article class="product-item">
				<h3>${e.nombre}</h3>
				<p>${e.descripcion}</p>
				<p>Precio: <strong>${d(e.precio)}</strong></p>
				<button type="button" data-product-id="${e.id}">Agregar</button>
			</article>
		`).join(``),i.querySelectorAll(`button[data-product-id]`).forEach(t=>{t.addEventListener(`click`,()=>{let n=Number(t.dataset.productId);n&&(e(n,1),f(),alert(`Producto agregado al carrito.`))})})}p(),f(),u&&u.addEventListener(`click`,()=>{r(),n()})}));o(),u();