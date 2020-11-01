class Aluno{
    constructor(cpf,nome, data_nascimento, sexo, nome_mae, nome_pai = null, email = null, telefone = null){
        this.cpf = cpf;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.nome_mae = nome_mae;
        this.nome_pai = nome_pai;
        this.email = email;
        this.telefone = telefone
    }
   
}

class Turma{
    constructor(codigo, nome, descricao, turno, alunos_matriculados = {}){
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.turno = turno;
        this.alunos_matriculados = alunos_matriculados;
        this.qtd_matriculas = Object.keys(alunos_matriculados).length;
    }

    matricular_aluno(Aluno) {
        this.qtd_matriculas++;
        this.alunos_matriculados[this.qtd_matriculas] = Aluno;
    }
    desmatricular_aluno(numero_matricula){
        delete this.alunos_matriculados[numero_matricula];
    }
}

aluno1 = new Aluno("099.099.099-99","Carlos", "10/10/2000", "Masculino","Maria")
aluno2 = new Aluno("088.088.088-88", "Eduarda", "11/11/2010", "Feminino","Daiane", "Joao")
aluno3 = new Aluno("088.088.088-88", "Miranda", "11/11/2010", "Masculino","Daiane", "Joao")

turma1 = new Turma("1", "Turma 1", "Esta é uma turma de teste", "Matutino", {1: aluno1})



turma1.matricular_aluno(aluno2)
turma1.matricular_aluno(aluno3)

console.log(turma1.alunos_matriculados)

turma1.desmatricular_aluno(2)
let lista_matriculados = "";



console.log(turma1.alunos_matriculados)

for (let key in turma1.alunos_matriculados){
    lista_matriculados = lista_matriculados + ("<li>Matrícula: " + key +
        " CPF: "+turma1.alunos_matriculados[key].cpf+
        " Nome:" +turma1.alunos_matriculados[key].nome+"</li>")
}

document.write("<div>Alunos matriculados na "+turma1.nome+":<ul>"+lista_matriculados+"</ul></div>")