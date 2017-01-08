package ClassesBasicasDoPonto;

import java.time.LocalDate;


public class Relatorio {
	int matricula;
	String NomeDoFuncionario;
	String setor;
	String funcao;
	LocalDate data;
	String horaEntrada;
	String horaSaida;
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNomeDoFuncionario() {
		return NomeDoFuncionario;
	}
	public void setNomeDoFuncionario(String nomeDoFuncionario) {
		NomeDoFuncionario = nomeDoFuncionario;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public String getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}
	
	
	
	

}
