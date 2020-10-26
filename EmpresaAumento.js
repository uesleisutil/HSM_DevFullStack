var salario = prompt("Digite o seu salário:");
var plano_de_aumento = prompt("Digite o seu plano de aumento - A(10%) - B(15%) - C(20%)");
var plano_a = 10;
var plano_b = 15;
var plano_c = 20;

var novo_salario;

switch (plano_de_aumento){
    case 'a' : novo_salario = parseFloat(salario) + parseFloat((salario*plano_a)/100);
    break;
    case 'b' : novo_salario = parseFloat(salario) + parseFloat((salario*plano_b)/100);
    break;
    case 'c' : novo_salario = parseFloat(salario) + parseFloat((salario*plano_c)/100);
    break;
    default: prompt("Digite um valor válido");
};

alert("O valor do seu novo salário é R$ "+novo_salario+".");