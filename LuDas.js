function calculaDesconto(valor){
    let valor_venda;
    let desconto1 = 0.1, desconto2 = 0.15, desconto_aplicado;

    if (parseFloat(valor) < 0){
        return "Valor inválido. A venda deve ser positiva"
    }
    else if (parseFloat(valor) <= 499.00){
        valor_venda = valor * (1 - desconto1);
        desconto_aplicado = desconto1;
    }
    else{
        valor_venda = valor * (1 - desconto2);
        desconto_aplicado = desconto2;
    }

    return {
        "desconto": desconto_aplicado*100+"%",
        "valor_venda": valor_venda,
        "valor_desconto": valor-valor_venda
        }
}


console.log(calculaDesconto(-5))

console.log(calculaDesconto(300))

console.log(calculaDesconto(500))