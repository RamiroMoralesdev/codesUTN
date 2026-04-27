import{i as e,n as t,o as n,p as r,s as i,t as a,u as o}from"../../../main-D2WXCwoL.js";/* empty css                      */import{n as s,t as c}from"../../../data-CTb6J966.js";var l=r((()=>{s(),e(),o();var r=document.getElementById(`cart-list`),a=document.getElementById(`cart-total`),l=document.getElementById(`logout-btn`);function u(e){return new Intl.NumberFormat(`es-AR`,{style:`currency`,currency:`ARS`,maximumFractionDigits:0}).format(e)}function d(){if(!r||!a)return;let e=i();if(e.length===0){r.innerHTML=`<p>El carrito esta vacio.</p>`,a.textContent=`Total: $ 0`;return}let t=e.map(e=>{let t=c.find(t=>t.id===e.productId);if(!t)return``;let n=t.precio*e.quantity;return`
			<article class="cart-item">
				<p><strong>${t.nombre}</strong></p>
				<p>Precio unitario: ${u(t.precio)}</p>
				<p>Cantidad: ${e.quantity}</p>
				<p>Subtotal: ${u(n)}</p>
			</article>
		`}).join(``),n=e.reduce((e,t)=>{let n=c.find(e=>e.id===t.productId);return n?e+n.precio*t.quantity:e},0);r.innerHTML=t,a.textContent=`Total: ${u(n)}`}d(),l&&l.addEventListener(`click`,()=>{n(),t()})}));a(),l();