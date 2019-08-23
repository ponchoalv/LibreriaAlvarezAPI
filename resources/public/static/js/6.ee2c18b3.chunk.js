(window["webpackJsonplibreria-ts"]=window["webpackJsonplibreria-ts"]||[]).push([[6],{218:function(e,t,a){e.exports=a.p+"static/media/logo-black.77a5377c.png"},219:function(e,t,a){e.exports=a.p+"static/media/logo-small.fd5c862c.png"},383:function(e,t,a){"use strict";a.r(t);var n=a(0),l=a.n(n),r=a(21),c=a(96),s=a(218),i=a.n(s),o=function(){return n.createElement("div",{className:"home"},n.createElement("img",{src:i.a,alt:"Librer\xeda Alvarez"}))},u=a(24),m=a(25),d=a(29),p=a(26),E=a(36),h=a(28),f=a(366),g=a(367),v=a(368),b=a(369),O=a(370),D=a(371),y=a(372),N=a(219),C=a.n(N),k=function(e){function t(e){var a;return Object(u.a)(this,t),(a=Object(d.a)(this,Object(p.a)(t).call(this,e))).toggle=a.toggle.bind(Object(E.a)(a)),a.state={isOpen:!1},a}return Object(h.a)(t,e),Object(m.a)(t,[{key:"render",value:function(){return n.createElement("div",{className:"sidebar"},n.createElement(f.a,{className:"top-row pl-4",dark:!0},n.createElement(g.a,{href:"/"},n.createElement("img",{className:"home-logo",width:"35",height:"35",src:C.a,alt:"Librer\xeda Alvarez"}),"Librer\xeda \xc1lvarez"),n.createElement(v.a,{onClick:this.toggle})),n.createElement(b.a,{isOpen:this.state.isOpen,navbar:!0},n.createElement(O.a,{vertical:!0},n.createElement(D.a,{className:"px-3"},n.createElement(y.a,{tag:c.b,exact:!0,to:"/",activeClassName:"active"},n.createElement("i",{className:"oi oi-home","aria-hidden":"true"}),"Home")),n.createElement(D.a,{className:"px-3"},n.createElement(y.a,{tag:c.b,to:"".concat(this.props.match.url,"/list"),activeClassName:"active"},n.createElement("i",{className:"oi oi-list-rich","aria-hidden":"true"}),"Lista de Precios")),n.createElement(D.a,{className:"px-3"},n.createElement(y.a,{tag:c.b,to:"".concat(this.props.match.url,"/upload"),activeClassName:"active"},n.createElement("i",{className:"oi oi-cloud-upload","aria-hidden":"true"}),"Cargar Listas")),n.createElement(D.a,{className:"px-3"},n.createElement(y.a,{tag:c.b,to:"".concat(this.props.match.url,"/sales"),activeClassName:"active"},n.createElement("i",{className:"oi oi-dollar","aria-hidden":"true"}),"Ventas")),n.createElement(D.a,{className:"px-3"},n.createElement(y.a,{tag:c.b,to:"".concat(this.props.match.url,"/logout"),activeClassName:"active"},n.createElement("i",{className:"oi oi-account-logout","aria-hidden":"true"}),"Logout")))))}},{key:"toggle",value:function(){this.setState({isOpen:!this.state.isOpen})}}]),t}(n.Component),x=a(53),w=a(27),L=a(23),T=a(373),j=a(377),F=a(378),P=a(49),S=n.lazy(function(){return Promise.all([a.e(2),a.e(5)]).then(a.bind(null,382))});function A(e){return n.createElement(n.Suspense,{fallback:e.fallback},n.createElement(S,{rows:e.rows,colorBoton:e.colorBoton,buttonText:e.buttonText}))}var z=a(374);var R=function(e){var t=e.row;return n.createElement("tr",null,n.createElement("td",null,t.desc),n.createElement("td",null,t.lista),n.createElement("td",null,B.format(t.price)),n.createElement("td",null,t.fecha))},B=new Intl.NumberFormat("es-AR",{currency:"ARS",minimumFractionDigits:2,style:"currency"});var U=function(e){var t=e.rows,a=e.searchText,l=e.selectedList,r=t.filter(function(e){return e.desc.includes(a)&&(""===l||e.lista===l)}).slice(0,20);return n.createElement(T.a,null,n.createElement(z.a,{responsive:!0},n.createElement("thead",{className:"thead-dark"},n.createElement("tr",null,n.createElement("th",null,"Descripci\xf3n"),n.createElement("th",null,"Lista"),n.createElement("th",null,"Precio"),n.createElement("th",null,"Fecha de la Lista"))),n.createElement("tbody",null,r.map(function(e,t){return n.createElement(R,{row:e,key:t})}))),n.createElement("div",{className:"d-flex flex-row-reverse"},n.createElement("div",{className:"p-2"}),n.createElement(A,{fallback:"Cargando...",rows:r,colorBoton:"info",buttonText:"Descargar planilla con datos filtrados"})))},I=a(375),M=a(384),J=a(376);var V=function(e){var t=e.searchText,a=e.updateSearch;return n.createElement(I.a,null,n.createElement(M.a,{addonType:"prepend"},"Buscar"),n.createElement(J.a,{placeholder:"Articulo",value:t,onChange:function(e){return a(e.currentTarget.value.toUpperCase())}}))};var H=function(e){var t=e.selectedDate,a=e.listsDateOptions,l=e.selectedDateChanged;return n.createElement(I.a,null,n.createElement(M.a,{addonType:"prepend"},"Fecha"),n.createElement(J.a,{type:"select",value:t.fecha,onChange:function(e){return l({fecha:e.currentTarget.value})},className:"custom-select"},a.map(function(e,t){return n.createElement("option",{key:t,value:e.fecha},e.fecha)})))};var X=function(e){var t=e.selectedList,a=e.selectOptions,l=e.selectedListChanged;return n.createElement(I.a,null,n.createElement(M.a,{addonType:"prepend"},"Lista"),n.createElement(J.a,{type:"select",value:t,onChange:function(e){return l(e.currentTarget.value.toUpperCase())},className:"custom-select"},n.createElement("option",{value:""},"Todas"),a.map(function(e,t){return n.createElement("option",{key:t,value:e},e)})))},q=function(e){function t(){return Object(u.a)(this,t),Object(d.a)(this,Object(p.a)(t).apply(this,arguments))}return Object(h.a)(t,e),Object(m.a)(t,[{key:"render",value:function(){return this.props.token?this.props.children:n.createElement(r.a,{to:this.props.fallbackUrl})}}]),t}(n.Component),G=function(e){function t(){return Object(u.a)(this,t),Object(d.a)(this,Object(p.a)(t).apply(this,arguments))}return Object(h.a)(t,e),Object(m.a)(t,[{key:"render",value:function(){return n.createElement(q,{fallbackUrl:"/",token:this.props.token},n.createElement(P.a,{loading:this.props.loading,error:this.props.error,initAction:this.props.init,loaded:this.props.loaded},n.createElement("div",null,n.createElement("h1",null,"Lista de Precios"),n.createElement("p",null,"Buscar entre ",n.createElement("b",null,this.props.prices.length)," articulos de librer\xeda y juguetes."),n.createElement(T.a,null,n.createElement(j.a,null,n.createElement(F.a,{sm:{size:4}},n.createElement(V,{searchText:this.props.searchText,updateSearch:this.props.updateSearchText})),n.createElement(F.a,{sm:{size:4}},n.createElement(X,{selectedList:this.props.selectedList,selectOptions:this.props.selectOptions,selectedListChanged:this.props.selectedListChanged})),n.createElement(F.a,{sm:{size:4}},n.createElement(H,{selectedDate:this.props.selectedDate,listsDateOptions:this.props.datesLoaded,selectedDateChanged:this.props.selectedDateChanged}))),n.createElement("br",null),n.createElement(j.a,null,n.createElement(F.a,null,n.createElement(U,{rows:this.props.prices,searchText:this.props.searchText,selectedList:this.props.selectedList}))),n.createElement(A,{fallback:"Cargando...",rows:this.props.prices,colorBoton:"primary",buttonText:"Descargar lista de precios completa"})))))}}]),t}(n.Component);var K=Object(w.b)(function(e){var t=e.prices,a=e.login;return{datesLoaded:t.datesLoaded,error:t.error,loaded:t.loaded,loading:t.loading,prices:t.prices,searchText:t.searchText,selectOptions:t.selectOptions,selectedDate:t.selectedDate,selectedList:t.selectedList,token:a.loginToken}},function(e){return{init:function(){return e(L.b())},selectedDateChanged:function(t){return e(L.h(t))},selectedListChanged:function(t){return e(L.i(t))},updateSearchText:function(t){return e(L.g(t))}}})(G),Q=a(22),W=a(379),Y=new Intl.NumberFormat("es-AR",{currency:"ARS",minimumFractionDigits:2,style:"currency"});var Z=Object(w.b)(function(e,t){return{row:t.row}},function(e){return{deleteSale:function(t){return e(Q.b(t))}}})(function(e){return n.createElement("tr",null,n.createElement("td",null,e.row.fecha),n.createElement("td",null,e.row.usuario),n.createElement("td",null,Y.format(e.row.monto)),n.createElement("td",null,n.createElement(W.a,{onClick:function(){return e.deleteSale(e.row.fecha)},color:"danger"},n.createElement("i",{className:"oi oi-trash","aria-hidden":"true"}))))});var $=function(e){var t=e.rows;return n.createElement(T.a,null,n.createElement(z.a,{responsive:!0},n.createElement("thead",{className:"thead-dark"},n.createElement("tr",null,n.createElement("th",null,"Fecha"),n.createElement("th",null,"Usuario"),n.createElement("th",null,"Monto"),n.createElement("th",null,"Acci\xf3n"))),n.createElement("tbody",null,t.map(function(e,t){return n.createElement(Z,{row:e,key:t})}))))},_=a(380);var ee=function(e){var t=e.cargarMonto;return n.createElement(I.a,null,n.createElement(M.a,{addonType:"prepend"},"Monto"),n.createElement(_.a,{onSubmit:function(e){e.preventDefault(),t(parseFloat(e.currentTarget.monto.value)),e.currentTarget.monto.value="",console.log(e)}},n.createElement(J.a,{type:"number",min:"0.0",step:"0.01",placeholder:"Monto de la venta",name:"monto"})))},te=new Intl.NumberFormat("es-AR",{currency:"ARS",minimumFractionDigits:2,style:"currency"}),ae=function(e){var t=e.sales.reduce(function(e,t){return e+t.monto},0);return l.a.createElement(P.a,{loading:e.loading,error:e.error,initAction:e.init,loaded:e.loaded},l.a.createElement("div",null,l.a.createElement("h1",null,"Ventas Diarias"),l.a.createElement("p",null,"El d\xeda ",l.a.createElement("b",null,e.selectedDate.fecha)," se realizaron "," ",l.a.createElement("b",null,e.sales.length)," ventas, sumando ",l.a.createElement("b",null,te.format(t))),l.a.createElement(T.a,{className:"xs"},l.a.createElement(j.a,null,l.a.createElement(F.a,{sm:{size:4}},l.a.createElement(H,{selectedDate:e.selectedDate,listsDateOptions:e.datesLoaded,selectedDateChanged:e.selectedDateChanged})),l.a.createElement(F.a,{sm:{size:4}},l.a.createElement(ee,{cargarMonto:function(t){e.addSale(t,e.username)}}))),l.a.createElement("br",null),l.a.createElement(j.a,null,l.a.createElement(F.a,null,l.a.createElement($,{rows:e.sales}))))))};var ne=Object(w.b)(function(e){var t=e.sales,a=e.login;return{sales:t.sales,loaded:t.loaded,loading:t.loading,error:t.error,selectedDate:{fecha:t.selectedDate},datesLoaded:t.datesLoaded,username:a.username?a.username:""}},function(e){return{init:function(){return e(Q.d())},selectedDateChanged:function(t){return e(Q.g(t.fecha))},addSale:function(t,a){return e(Q.a(t,a))}}})(ae),le=a(8),re=a(220),ce=a.n(re),se=a(51),ie=a.n(se),oe=a(252),ue=a.n(oe),me=a(56),de=a.n(me),pe=a(54),Ee=a.n(pe),he=a(55),fe=a.n(he);var ge=function(e){var t=e.row,a=e.deleteList;return n.createElement("tr",null,n.createElement("td",null,t.lista),n.createElement("td",null,t.fecha),n.createElement("td",null,t.registros),n.createElement("td",null,n.createElement(W.a,{color:"danger","aria-label":"Eliminar",onClick:function(){return a({lista:t.lista,fecha:t.fecha})}},"Eliminar")))},ve=a(57),be=a.n(ve),Oe=a(60),De=a.n(Oe),ye=a(61),Ne=a.n(ye),Ce=a(58),ke=a.n(Ce),xe=a(59),we=a.n(xe),Le=a(41),Te=a.n(Le),je=a(251),Fe=a.n(je),Pe=a(44),Se=a.n(Pe),Ae=a(43),ze=a.n(Ae),Re=a(381);var Be=function(e){var t=e.selectOptions,a=e.name;return n.createElement(Te.a,null,n.createElement(Re.a,{for:"nombre-lista"},"Nombre de lista:"),n.createElement(J.a,{type:"select",name:a,className:"custom-select"},t.map(function(e,t){return n.createElement("option",{key:t,value:e},e)})))};var Ue=function(e){return n.createElement(be.a,{className:"border-primary"},n.createElement(ke.a,null,n.createElement("h4",null,"Cargar una nueva planilla")),n.createElement(we.a,{onSubmit:function(t){t.preventDefault();var a=new FormData(t.currentTarget);e.uploadForm(a)}},n.createElement(De.a,null,n.createElement(Te.a,null,n.createElement(ze.a,{for:"file"},"Planilla(.xlsx):"),n.createElement(Se.a,{type:"file",name:"file",id:"file",accept:".xls,.xlsx"}),n.createElement(Fe.a,{color:"muted"},"Seleccionar el archivo de la planilla a cargar (formato .xlsx)")),n.createElement(Be,{name:"tipo-lista",selectOptions:e.listTypeOptions}),n.createElement(Te.a,null,n.createElement(ze.a,{for:"nombre-lista"},"Nombre de lista:"),n.createElement(Se.a,{type:"text",name:"nombre-lista",id:"nombre-lista"})),n.createElement(Se.a,{type:"hidden",name:"nombre-hoja",value:"precios"}),n.createElement(Se.a,{type:"hidden",name:"fecha",value:e.fecha})),n.createElement(Ne.a,null,n.createElement(ie.a,{color:"primary"},"Subir Planilla"),"  ",n.createElement(ie.a,{color:"danger",onClick:e.toggleNuevaPlanilla},"Restablecer"))))};var Ie=function(e){return n.createElement("div",null,n.createElement("h3",null,"Planillas cargadas:"),n.createElement(z.a,{responsive:!0},n.createElement("thead",{className:"thead-dark"},n.createElement("tr",null,n.createElement("th",null,"Lista"),n.createElement("th",null,"Fecha"),n.createElement("th",null,"# Registros"),n.createElement("th",null,"Acci\xf3n"))),n.createElement("tbody",null,e.filteredlistOptions.map(function(t,a){return n.createElement(ge,{row:t,key:a,deleteList:e.deleteList})}))),n.createElement("br",null),e.nuevaPlanilla?n.createElement(Ue,{uploadForm:e.uploadForm,fecha:e.selectedDate.fecha,listTypeOptions:e.listTypeOptions,toggleNuevaPlanilla:e.toggleNuevaPlanilla}):n.createElement(W.a,{color:"success",onClick:e.toggleNuevaPlanilla},"Cargar nueva planilla"))},Me=function(e){function t(){var e,a;Object(u.a)(this,t);for(var n=arguments.length,l=new Array(n),r=0;r<n;r++)l[r]=arguments[r];return(a=Object(d.a)(this,(e=Object(p.a)(t)).call.apply(e,[this].concat(l)))).dateChange=function(e){a.props.selectedDateChanged({fecha:e.toISOString().split("T")[0]})},a.getDate=function(){var e=a.props.selectedDate.fecha.split("-");return new Date(+e[0],+e[1]-1,+e[2])},a}return Object(h.a)(t,e),Object(m.a)(t,[{key:"render",value:function(){return n.createElement(q,{fallbackUrl:"/",token:this.props.token},n.createElement(P.a,{loading:this.props.loading,error:this.props.error,initAction:this.props.init,loaded:!1},n.createElement("h1",null,"Administrar la carga de listas"),n.createElement("p",null,"Fecha selecionada: ",n.createElement("b",null,this.props.selectedDate.fecha)),n.createElement(Ee.a,null,this.props.addingNewDate?n.createElement(fe.a,null,n.createElement(de.a,{sm:{size:4}},n.createElement(ue.a,null,n.createElement(ce.a,{onChange:this.dateChange,clearIcon:null,value:this.getDate(),locale:"es-419"}),n.createElement(ie.a,{color:"danger","aria-label":"Restablecer",onClick:this.props.clearEditingDate},n.createElement("i",null,"X"))))):n.createElement(fe.a,null,n.createElement(de.a,{sm:{size:4}},n.createElement(H,{listsDateOptions:this.props.listsDateOptions,selectedDate:this.props.selectedDate,selectedDateChanged:this.props.selectedDateChanged})),n.createElement(de.a,{sm:{size:4}},n.createElement(ie.a,{color:"info",onClick:this.props.startEditing},"Agregar Nueva Fecha"))),n.createElement("br",null),n.createElement(fe.a,null,n.createElement(de.a,null,n.createElement(Ie,{uploadForm:this.props.uploadForm,selectedDate:this.props.selectedDate,filteredlistOptions:this.props.filteredlistOptions,deleteList:this.props.deleteList,listTypeOptions:this.props.listTypeOptions,nuevaPlanilla:this.props.nuevaPlanilla,toggleNuevaPlanilla:this.props.toggleNuevaPlanilla}))))))}}]),t}(n.Component);var Je=Object(w.b)(function(e){var t=e.upload,a=e.login;return{addingNewDate:t.addingNewDate,error:t.error,filteredlistOptions:t.filteredLists,listTypeOptions:t.listTypeOptions,listsDateOptions:t.listsDateOptions,loading:t.loading,nuevaPlanilla:t.nuevaPlanilla,selectedDate:t.selectedDate,token:a.loginToken}},function(e){return{clearEditingDate:function(){return e(le.a())},deleteList:function(t){return e(le.c(t))},init:function(){return e(le.e())},selectedDateChanged:function(t){return e(le.o(t))},startEditing:function(){return e(le.k())},toggleNuevaPlanilla:function(){return e(le.n())},uploadForm:function(t){return e(le.p(t))}}})(Me);t.default=function(e){var t=e.match;return n.createElement("div",{className:"app"},n.createElement(k,{match:t}),n.createElement("div",{className:"main"},n.createElement("div",{className:"top-row px-4"},n.createElement(c.a,{to:"/",className:"ml-md-auto"},"libreria-alvarez")),n.createElement("div",{className:"content px-4"},n.createElement(r.d,null,n.createElement(r.b,{exact:!0,path:"".concat(t.url),component:o}),n.createElement(r.b,{exact:!0,path:"".concat(t.url,"/list"),component:K}),n.createElement(r.b,{exact:!0,path:"".concat(t.url,"/upload"),component:Je}),n.createElement(r.b,{exact:!0,path:"".concat(t.url,"/sales"),component:ne}),n.createElement(r.b,{component:x.a})))))}}}]);
//# sourceMappingURL=6.ee2c18b3.chunk.js.map