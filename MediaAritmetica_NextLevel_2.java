// Programa para a média aritmética.

import java.util.Scanner;

public class MediaAritmetica_NextLevel_2 {
    public static void main(final String args[]) {

        final java.util.Scanner nota = new Scanner(System.in);
        
        // Primeiro bimestre.
        double prova_b1, projeto_b1, exercicio_b1, mooc_b1;
        System.out.print("Digite a nota da prova do primeiro bimestre: ");
        prova_b1 = nota.nextFloat();
        
        System.out.print("Digite a nota do projeto do primeiro bimestre : ");
        projeto_b1 = nota.nextFloat();
        
        System.out.print("Digite a nota do exercício do primeiro bimestre: ");
        exercicio_b1 = nota.nextFloat();
       
        System.out.print("Digite a nota do MOOC do primemiro bimestre: ");
        mooc_b1 = nota.nextFloat();

        // Segundo bimestre.
        double prova_b2, projeto_b2, exercicio_b2, mooc_b2;
        System.out.print("Digite a nota da prova do segundo bimestre: ");
        prova_b2 = nota.nextFloat();
        
        System.out.print("Digite a nota do projeto do segundo bimestre : ");
        projeto_b2 = nota.nextFloat();
        
        System.out.print("Digite a nota do exercício do segundo bimestre: ");
        exercicio_b2 = nota.nextFloat();
       
        System.out.print("Digite a nota do MOOC do segundo bimestre: ");
        mooc_b2 = nota.nextFloat();

        // Terceiro bimestre.
        double prova_b3, projeto_b3, exercicio_b3, mooc_b3;
        System.out.print("Digite a nota da prova do terceiro bimestre: ");
        prova_b3 = nota.nextFloat();
        
        System.out.print("Digite a nota do projeto do terceiro bimestre : ");
        projeto_b3 = nota.nextFloat();
        
        System.out.print("Digite a nota do exercício do terceiro bimestre: ");
        exercicio_b3 = nota.nextFloat();
       
        System.out.print("Digite a nota do MOOC do terceiro bimestre: ");
        mooc_b3 = nota.nextFloat();

        // Quarto bimestre.
        double prova_b4, projeto_b4, exercicio_b4, mooc_b4;
        System.out.print("Digite a nota da prova do quarto bimestre: ");
        prova_b4 = nota.nextFloat();
        
        System.out.print("Digite a nota do projeto do quarto bimestre : ");
        projeto_b4 = nota.nextFloat();
        
        System.out.print("Digite a nota do exercício do quarto bimestre: ");
        exercicio_b4 = nota.nextFloat();
       
        System.out.print("Digite a nota do MOOC do quarto bimestre: ");
        mooc_b4 = nota.nextFloat();

        nota.close();

        // Soma das notas bimestrais.
        double prova_s, projeto_s, exercicio_s, mooc_s;
        prova_s     = (prova_b1+prova_b2+prova_b3+prova_b4);
        projeto_s   = (projeto_b1+projeto_b2+projeto_b3+projeto_b4);
        exercicio_s = (exercicio_b1+exercicio_b2+exercicio_b3+exercicio_b4);
        mooc_s      = (mooc_b1+mooc_b2+mooc_b3+mooc_b4);

        // Atribui os pesos referentes a cada atividade.
        double prova, projeto, exercicio, mooc;
        prova     = prova_s*3;
        projeto   = projeto_s*3;
        exercicio = exercicio_s*2;
        mooc      = mooc_s*3;
        
        // Média semestral com os pesos de cada atividade.
        double media;
        media = ((prova)+(projeto)+(exercicio)+(mooc))/4;

        if(media <= 8){
            System.out.println("O aluno foi REPROVADO. ");
            double prova_final;
            prova_final = 10-media; 
            System.out.println("A media final do aluno é: " + media + " pontos.");
            System.out.print("O aluno precisa de " + prova_final + " pontos na prova final");          
        }
        else
        {
            System.out.println("O aluno foi APROVADO. ");
            System.out.print("A media final do aluno é: " + media + " pontos.");
        }
    }
}