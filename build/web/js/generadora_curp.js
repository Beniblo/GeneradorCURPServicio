async function realizarCurp() 
{
    let nom1 = document.getElementById("txtPrimerNombre").value.toUpperCase().trim();  
    let nom2 = document.getElementById("txtSegundoNombre").value.toUpperCase().trim();
    let ap1 = document.getElementById("txtApellidoPaterno").value.toUpperCase().trim();  
    let ap2 = document.getElementById("txtApellidoMaterno").value.toUpperCase().trim();   
    let anio = document.getElementById("txtAnio").value;
    let dia = document.getElementById("txtDia").value;
    let mes = document.getElementById("txtMes").value;
    let ent = document.getElementById("cmbEntidad").value;  
    let gen = document.getElementById("cmbGenero").value;

    let fn = dia.padStart(2, '0') + mes.padStart(2, '0') + anio;

    let res = await generar(nom1, nom2, ap1, ap2, gen, fn, ent); 
    
    document.getElementById("txtCurpResultado").innerText = res.curpGenerada;
}

async function generar(nom1, nom2, ap1, ap2, gen, fn, ent, cg)
{
    let url = "api/restciudadano/generarcurp?nom1=" + nom1 + "&nom2=" + nom2 + "&ap1=" + ap1 + "&ap2=" + ap2 + 
                              "&gen=" + gen + "&fn=" + fn + "&ent=" + ent + "&cg=NULL";

    let resp = await fetch(url);
    let data = await resp.json();
    
    console.log("Respuesta del servidor:", data);
    
    return data;
}

function limpiarCampos() {
    document.getElementById("txtApellidoPaterno").value = "";
    document.getElementById("txtApellidoMaterno").value = "";
    document.getElementById("txtPrimerNombre").value = "";
    document.getElementById("txtSegundoNombre").value = "";
    document.getElementById("txtAnio").value = "";
    document.getElementById("txtDia").value = "";
    document.getElementById("txtMes").value = "";
    document.getElementById("cmbGenero").value = "M";
    document.getElementById("cmbEntidad").value = "";
    document.getElementById("txtCurpResultado").textContent = "";
}