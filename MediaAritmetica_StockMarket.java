import java.util.Scanner;
public class MediaAritmetica_StockMarket {
        public static void main(String[] args) {
        Scanner scan    = new Scanner(System.in);
        int[][] vetor1  = new int[4][7];
        int daily_value = 0, mean_month = 0;
        double di     v = 0, mean_week = 0;

        for(int l= 0; l < vetor1.length; l++) {
            for (int c =0 ; c < vetor1[l].length; c ++) {
                daily_value += 1;	
                System.out.println("O valor das ações do dia"+ daily_value);
                vetor1[l][c] = scan.nextInt();
                mean_month = (vetor1[l][c] + mean_month);
            }
            System.out.print("\n");
        }

        for(int l= 0; l < vetor1.length; l++) {
            for (int c= 0; c < vetor1[l].length; c ++) {
                System.out.print(vetor1[l][c] + " ");
                }
            System.out.print("\n");
            }

        int max_value = 0;
        for(int l= 0; l < vetor1.length; l++) {
            for (int c= 0; c < vetor1[l].length; c ++) {
                if (vetor1[l][c] > max_value) {
                    max_value = vetor1[l][c];
                }
            }
        }

        int min_value = max_value;
        for(int l= 0; l < vetor1.length; l++) {
            for (int c= 0; c < vetor1[l].length; c ++) {
                if (vetor1[l][c] < min_value) {
                    min_value = vetor1[l][c];
                }
            }
        }
        mean_week = mean_month / 4;
        System.out.println("Ação de max_value valor na mean_weekana = "+ max_value);
        System.out.println("Ação de min_value valor na mean_weekana = "+ min_value);
        System.out.println("Media das ações no Mês= "+ mean_month);
        System.out.println("Média das ações por mean_weekana: "+ mean_week);
    }
}
