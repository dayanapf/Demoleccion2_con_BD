

window.onsubmit = function validarform(){
    
    var idbutaca = document.formulario_balcon.id_nombre;
    var idplatea = document.formulario_platea.id_nombre;


//variables auxiliares
    var campos_vacios = ["Error\n"];
    var idbutaca_vacia = esta_vacio(idbutaca);
    var idplatea_vacia = esta_vacio(idplatea);


//butaca
    if(!idbutaca_vacia) 
    {
        if(!empesar_con_mayuscula(idbutaca.value))
            campos_vacios.push("El Id de la butaca debe ser una letra en mayuscula seguido de un numero\n");
        
        
    }  
//platea
    if(!idplatea_vacia) 
    { 
        if(!empesar_con_mayuscula(idplatea.value))
            campos_vacios.push("El Id de la butaca debe ser una letra en mayuscula seguido de un numero\n");
    } 
 


    if(campos_vacios.length > 1)
    {
        alert(campos_vacios);
        return false;
    }
    else{
        alert("Formulario válido");
       
    }     
    
}


    
var formulario_balcon = "formulario_balcon";
var formulario_platea = "formulario_platea";
window.onload = function(){
desahbilitar(formulario_platea);
}

window.onchange = function habilitarForm() {   
    
    var otro = document.habilitar.tipo_butaca;   
    
    if(otro.value == "Balcon"){
        //window.alert(otro.value);
        habilitar(formulario_balcon);
        desahbilitar(formulario_platea);
        
    }else{
        //window.alert(otro.value);
        habilitar(formulario_platea);
        desahbilitar(formulario_balcon);
        
    }
}

function desahbilitar(id){
    frm = document.forms[id];
    for(i=0; ele=frm.elements[i]; i++)
    ele.disabled=true;

}
function habilitar(id){
    frm = document.forms[id];
    for(i=0; ele=frm.elements[i]; i++)
    ele.disabled=false;
}



function esta_vacio(valor){
    var vacio = false;
    var exp_no_espacio = /^\s+$/;
    if (!valor.value || valor.value.length == 0 || exp_no_espacio.test(valor.value) )
    {
        return true;
    }
    return vacio;
}

//comprobar que el o los nombre empiesan con mayuscula y tienen solo letras
function empesar_con_mayuscula(cadena){
    var exp = /^[A-Z][0-9]$/;  
    var todas_empiezan_con_mayuscula = true;  
    if(!exp.test(cadena)){            
            todas_empiezan_con_mayuscula = false;
    }        
    
    return todas_empiezan_con_mayuscula;
}