alert("Olá, Seja bem vindo!");

var resposta = prompt("Deseja Participar da Pesquisa?");
var qtd_entrevistados = 0;
var menos_que_dez = 0;
var deDezAQuinze = 0;
var maisDeQuinze = 0;

do{ 

    var qtd_visitas = prompt("Quantas vezes você utilizou o Restaurante Universitário neste mês?");

    if(qtd_visitas < 10){
        menos_que_dez++;
    }else if(qtd_visitas >= 10 && qtd_visitas <=15){
        deDezAQuinze++;
    }else if(qtd_visitas > 15){
        maisDeQuinze++;
    }

    var resposta = prompt("Deseja Participar da Pesquisa?");

    qtd_entrevistados++
}while(resposta == "sim"){};

var total_visitas = (menos_que_dez+deDezAQuinze+maisDeQuize);

var porcentagem_menos_que_dez = (menos_que_dez / qtd_entrevistados)*100;
var porcentagem_de_dez_a_quinze = (deDezAQuinze / qtd_entrevistados)*100;
var porcentagem_maisDeQuinze = (maisDeQuinze / qtd_entrevistados)*100;

document.write("O percentual de alunos que utilizaram menos de 10 vezes o restaurante é de "+porcentagem_menos_que_dez.toFixed(1)+"%.");
document.write("<br>");
document.write("O percentual de alunos que utilizaram entre 10 e 15 vezes é de "+porcentagem_de_dez_a_quinze.toFixed(1)+"%.");
document.write("<br>");
document.write("O percentual de alunos que utilizaram o restaurante acima de 15 vezes é de "+porcentagem_maisDeQuinze.toFixed(1)+"%.");
document.write("<br>");
document.write("A quantidade de alunos entrevistados é de: "+qtd_entrevistados);
document.write("<br>")
        