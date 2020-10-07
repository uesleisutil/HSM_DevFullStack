import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;

class Empresa{
	String nome;
	String cnpj;
	Date data_abertura;
	Boolean sede;
	Double faturamento_anual;
	List<Colaborador> colaboradores;
	
	public Empresa(String nome, String cnpj, Date data_abertura, Boolean sede,
			Double faturamento_anual) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.data_abertura = data_abertura;
		this.sede = sede;
		this.faturamento_anual = faturamento_anual;
	}
}

class Matriz extends Empresa{
	
	List<Socio> socios;
	List<Filial> filiais;
	double faturamento_total;
	
	public Matriz(String nome, String cnpj, Date data_abertura, Boolean sede,
			Double faturamento_anual,List<Socio> socios, List<Filial> filiais) {
		
		super(nome, cnpj, data_abertura, sede,faturamento_anual);
		this.socios = socios;
		this.filiais = filiais;
		this.faturamento_total = calcula_faturamento_total();
		
	}
	
	public double calcula_faturamento_total() {
		this.faturamento_total = this.faturamento_anual;
		
		for (Filial i : this.filiais) {
			this.faturamento_total += i.faturamento_anual;
		}
		return this.faturamento_total;
		
	}
	public Filial filial_menor() {
		
		Filial filial_menor = this.filiais.get(0);
		
		for (Filial i: this.filiais) {
			if (filial_menor.faturamento_anual > i.faturamento_anual) {
				filial_menor = i;
			}
		}
		
		return filial_menor;
	
	}
	public Filial filial_maior() {
		
		Filial filial_maior = this.filiais.get(0);
		
		for (Filial i: this.filiais) {
			if (filial_maior.faturamento_anual < i.faturamento_anual) {
				filial_maior = i;
			}
		}
		
		return filial_maior;
	
	}
	
	public double[] dados_media_salarial() {
		double massa_salarial = 0;
		int qtd_funcionarios = 0;
		double dados_media[] = new double[2];
				
		for (Colaborador i : this.colaboradores) {
			massa_salarial += i.salario_anual;
			qtd_funcionarios +=1;
		}
		
		for (Filial k : this.filiais) {

			for (Colaborador j : k.colaboradores) {
				massa_salarial += j.salario_anual;
				qtd_funcionarios += 1;
			}
		}
		
		dados_media[0] = massa_salarial;
		dados_media[1] = qtd_funcionarios;
		
		return dados_media;
	}
	
}
class Filial extends Empresa{
	String codigo_filial;
	Pessoa responsavel;
	String endereco;

	public Filial(String nome, String cnpj, Date data_abertura, Boolean sede,
			Double faturamento_anual,String codigo_filial, Pessoa responsavel, String endereco) {
		
		super(nome, cnpj, data_abertura, sede,faturamento_anual);
		this.codigo_filial = codigo_filial;
		this.responsavel = responsavel;
		this.endereco = endereco;
		
	}
}
class Pessoa{
	String nome;
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
}

class Colaborador extends Pessoa{
	String matricula;
	Double salario_anual;
	Empresa vinculo;
	
	public Colaborador(String nome, String matricula, Double salario_anual, Empresa vinculo) {
		super(nome);
		this.matricula = matricula;
		this.salario_anual = salario_anual;
		this.vinculo = vinculo;
	}
}

class Socio extends Pessoa{
	String cpf;
	String telefone;
	Date data_nascimento;
	
	public Socio(String nome, String cpf, String telefone, Date data_nascimento) {
		super(nome);
		this.cpf = cpf;
		this.telefone = telefone;
		this.data_nascimento = data_nascimento;
	}
}
public class Ex_5 {

	public static void main(String[] args) {

		//Inicializa as listas
		List<Socio> lista_socios = new ArrayList<Socio>();
		List<Filial> lista_filiais = new ArrayList<Filial>();
		List<Colaborador> lista_colaboradores1 = new ArrayList<Colaborador>();
		List<Colaborador> lista_colaboradores2 = new ArrayList<Colaborador>();
		List<Colaborador> lista_colaboradores3 = new ArrayList<Colaborador>();
		
		
		
		//Cria as empresas filiais
		Date data_abertura2 = new GregorianCalendar(1975,1,31).getTime();
		Date data_abertura3 = new GregorianCalendar(1980,1,31).getTime();
		Filial f_empresa2 = new Filial ("Monstros SA", "03.000.000/0022-05", data_abertura2, false
				, 40000.00, "f1", null, "Rua Treze");
		
		Filial f_empresa3 = new Filial ("Monstros SA", "03.000.000/0033-05", data_abertura3, false
				, 5000.00, "f2", null, "Rua Vinte");
		
		
		//Cria os sócios
				Date data_nascimento1 = new GregorianCalendar(1990,1,31).getTime();
				Socio socio1 = new Socio("Carlos", "123.456.789-12", "(11) 3333-4444", data_nascimento1);
				Date data_nascimento2 = new GregorianCalendar(1980,1,31).getTime();
				Socio socio2 = new Socio("Eduardo", "543.543.543-12", "(11) 2222-2222", data_nascimento2);
		
		//Cria a empresa matriz
		lista_socios.add(socio1);
		lista_socios.add(socio2);
		
		lista_filiais.add(f_empresa2);
		lista_filiais.add(f_empresa3);
		
		Date data_abertura1 = new GregorianCalendar(1970,1,31).getTime();
		Matriz m_empresa1 = new Matriz ("Monstros SA", "03.000.000/0001-05", data_abertura1, true
				, 1000000.00, lista_socios, lista_filiais);
	
		
		//Cria colaboradores
		Colaborador col1 = new Colaborador("Marcia", "10", 200000.00, f_empresa2);
		Colaborador col2 = new Colaborador("Maria", "11", 300000.00, f_empresa2);
		Colaborador col3 = new Colaborador("Carvalho", "12", 400000.00, f_empresa3);
		Colaborador col4 = new Colaborador("Miranda", "14", 700000.00, m_empresa1);
		
		
		//Aloca colaboradores à empresa2
		lista_colaboradores1.add(col1);
		lista_colaboradores1.add(col2);
		f_empresa2.colaboradores = lista_colaboradores1;
		

		//Aloca colaboradores à empresa3
		lista_colaboradores2.add(col3);
		f_empresa3.colaboradores = lista_colaboradores2;
		
		
		//Aloca colaboradores à empresa1 (matriz)
		lista_colaboradores3.add(col4);
		m_empresa1.colaboradores = lista_colaboradores3;
		
				
		
		//Define os responsáveis pelas empresas
		f_empresa2.responsavel = col2;
		f_empresa3.responsavel = col3;

		
		//1. cálculo do faturamento anual. Se houver filiais, esse faturamento é
		//somado ao da sede;
		System.out.println("O faturamento total anual do grupo da empresa "+m_empresa1.nome+
				" foi de R$"+m_empresa1.calcula_faturamento_total());
		
		//2. a filial com maior e menor faturamento, caso elas existam;
		System.out.println("A filial do grupo "+m_empresa1.nome+ " com menor faturamento é a de CNPJ "
		+m_empresa1.filial_menor().cnpj+" e a de maior faturamento é a de CNPJ "+m_empresa1.filial_maior().cnpj);
	
		//3. a média salarial da empresa;
		System.out.println("A média salarial do grupo "+m_empresa1.nome+" é de R$"+
		m_empresa1.dados_media_salarial()[0]/m_empresa1.dados_media_salarial()[1]);
		
		//4. o balanço anual da empresa, que consiste na diferença entre o faturamento anual e a soma dos
		//salários dos colaboradores, mostrando se ele foi positivo ou negativo;
		System.out.println("O balanço das empresas do grupo "+m_empresa1.nome+" foi de R$"+
		(m_empresa1.calcula_faturamento_total()-m_empresa1.dados_media_salarial()[0]));
	
	}
	
}