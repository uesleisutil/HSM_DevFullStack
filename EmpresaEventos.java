import java.util.Scanner;
public class EmpresaEventos {
    class Evento{
		String nome;
		Responsavel responsavel;
		String data_inicio;
		String data_termino;
		int carga_horaria;
		List <Palestra> palestras;
		
		public Evento(String in_nome, Responsavel in_responsavel, String in_data_inicio,
				String in_data_termino, List <Palestra> in_palestras) {
			nome = in_nome;
			responsavel = in_responsavel;
			data_inicio = in_data_inicio;
			data_termino = in_data_termino;
			palestras = in_palestras;
			calcula_carga_horaria();
		}
		
		private void calcula_carga_horaria() {
			int carga_horaria = 0;
			for (Palestra i : this.palestras) {
				carga_horaria += i.carga_horaria;
			}
			this.carga_horaria = carga_horaria;
			
		}
		
		public void gasto_responsavel() {
			double gasto = this.carga_horaria * this.responsavel.valor_hora;
			String resultado = "O valor gasto pelo responsável para o evento " + 
					this.nome+" foi de R$"+gasto;
			System.out.println(resultado);
		}
		
		public void gasto_por_palestra() {
			for (Palestra i : this.palestras) {
				System.out.println("O valor da palestra "+i.titulo+" é de R$"
						+(i.palestrante.valor_hora * i.carga_horaria));
			}
		}
		
		public void gasto_total_palestras() {
			double valor_total = 0;
			for (Palestra i : this.palestras) {
				valor_total += i.carga_horaria * i.palestrante.valor_hora;
			}
			
			System.out.println("O valor total gasto com palestras no evento "+ this.nome +
					" foi de R$"+valor_total);
		}
		
		public void palestra_mais_cara() {
			
			Palestra palestra_cara = this.palestras.get(0);
			double valor_palestra_cara = palestra_cara.carga_horaria*palestra_cara.palestrante.valor_hora;
			for (Palestra i : this.palestras) {
				double valor_palestra = i.carga_horaria * i.palestrante.valor_hora;
				if (valor_palestra > valor_palestra_cara) {
					palestra_cara = i;
					valor_palestra_cara = valor_palestra;
				}
			}
			System.out.println("A palestra mais cara foi: "+palestra_cara.titulo+
					"\n" +"E os dados do seu palestrante são: "+
					"\n" +"Nome:"+ palestra_cara.palestrante.nome+
					"\n" +"Contato:"+ palestra_cara.palestrante.contato+
					"\n" +"Valor da hora:"+ palestra_cara.palestrante.valor_hora);
		}
		
		public void palestra_mais_barata() {
			
			Palestra palestra_barata = this.palestras.get(0);
			double valor_palestra_barata = palestra_barata.carga_horaria*palestra_barata.palestrante.valor_hora;
			for (Palestra i : this.palestras) {
				double valor_palestra = i.carga_horaria * i.palestrante.valor_hora;
				if (valor_palestra < valor_palestra_barata) {
					palestra_barata = i;
					valor_palestra_barata = valor_palestra;
				}
			}
			System.out.println("A palestra mais barata foi: "+palestra_barata.titulo+
					"\n" +"E os dados do seu palestrante são: "+
					"\n" +"Nome:"+ palestra_barata.palestrante.nome+
					"\n" +"Contato:"+ palestra_barata.palestrante.contato+
					"\n" +"Valor da hora:"+ palestra_barata.palestrante.valor_hora);
		}
				
	}
	
	class Responsavel{
		String nome_completo;
		String telefone;
		double valor_hora;
		String info_adicional;
		
		public Responsavel(String in_nome_completo, String in_telefone, double in_valor_hora) {
			nome_completo = in_nome_completo;
			telefone = in_telefone;
			valor_hora = in_valor_hora;
			
		}
	}
	
	class Palestrante{
		String nome;
		String contato;
		double valor_hora;
		
		public Palestrante(String in_nome, String in_contato, double in_valor_hora) {
			this.nome = in_nome;
			this.contato = in_contato;
			this.valor_hora = in_valor_hora;
			
		}
	}
	
	class Palestra{
		String titulo;
		String hora_inicio;
		Palestrante palestrante;
		String descricao;
		int carga_horaria;
		
		public Palestra (String in_titulo, String in_hora_inicio, Palestrante in_palestrante,
				String in_descricao, int in_carga_horaria) {
			titulo = in_titulo;
			hora_inicio = in_hora_inicio;
			palestrante = in_palestrante;
			descricao = in_descricao;
			carga_horaria = in_carga_horaria;
		}
	}



public class Ex4 {

		public static void main(String[] args) {
		// TODO Auto-generated method stub
		Responsavel resp1 = new Responsavel("João ","(11)99999-8888",50);
		Palestrante palestrante1 = new Palestrante("José", "joao@joao.com", 100);
		Palestrante palestrante2 = new Palestrante("Carlos", "carlos1900@carlos.com", 150);
		Palestra palestra1 = new Palestra("Programação Java", "9h", palestrante1, "Intro HSM", 
				5);
		Palestra palestra2 = new Palestra("Programação JavaScript", "15h", palestrante2, "Intro HSM2", 
				3);
		List <Palestra> palestras = new ArrayList<Palestra>();
		
		palestras.add(palestra1);
		palestras.add(palestra2);
		
		Evento meu_evento = new Evento("FullStack", resp1, "05/10/2020",
				"30/06/2020", palestras);
		
		meu_evento.gasto_por_palestra();
		meu_evento.gasto_total_palestras();
		meu_evento.gasto_responsavel();
		meu_evento.palestra_mais_cara();
		meu_evento.palestra_mais_barata();
		
	}

}