function criaBaralho(){
    let valores = [];
    let cartas_simbolos = ["Às", "Valete", "Dama", "Rei"]
    let nipes = ['copas', 'espadas', 'ouros', 'paus'];
    let baralho = []

    for (let i = 2; i<11 ;i++){
        valores.push(i)
    }
    
    for(let j in cartas_simbolos){
        valores.push(cartas_simbolos[j])
    }

    for (let k in nipes){
        for (l in valores){
            baralho.push(valores[l] + " de "+nipes[k])
        }
    }

    return baralho;
}

function exibir(){
    baralho = criaBaralho()
    
    adivinha = true;
    while (adivinha){

        index_carta = Math.floor(Math.random()*baralho.length)
        alert(baralho[index_carta])
        resp = prompt("Acertei a carta?");
        baralho.splice(index_carta,1)
        if (resp.toLowerCase() == "sim"){
            adivinha = false;
        }
        if (baralho.length == 0){
            adivinha = false;
            alert("Acabaram as cartas!")
        }

    }
} 

adivinha()