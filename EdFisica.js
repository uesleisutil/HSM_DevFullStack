var nome   = prompt("Nome do aluno:");
var altura = prompt("Altura do aluno:");
var peso   = prompt("Peso do aluno:");
var imc    = peso/(altura*altura);

if(imc <= 18.5){
    document.write("Resultado: Seu IMC é:"+imc+". Você está abaixo do peso. Classificação: Magreza Grau 0");
    }else if(imc >18.5 && imc< 24.9){
    document.write(" Resultado: Seu IMC é:"+imc+". Seu peso está normal Classificação: Normal Grau 0");
}else if(imc >25 && imc < 29.9){
    alert("Resultado: Seu IMC é:"+imc+". Você está acima do peso. Classificação: Sobrepeso Grau 1 ");
}else if (imc>30 && imc< 39.9) {
    alert(" Resultado: Seu IMC é:"+imc+". Você está acima do peso \nClassificação: Obesidade\nGrau 2 ");
}else if(imc >40.0) {
    alert("Resultado: Seu IMC é de:"+imc+". Você está acima do peso \nClassificação: Obesidade Grave\nGrau 3 ");

}