package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import ClassesBasicasDoPonto.DadosFuncionarios;

import conexao.ConnectionFactory;


public class InserirDadosDoFuncionarioDao {
	private Connection connection;

	public InserirDadosDoFuncionarioDao() {

		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void salvar(DadosFuncionarios inserirdados) {

		try {
			            

			String sql = "INSERT INTO " + inserirdados.getNomeDoFuncionario() +"(nomeFuncionario, setor, funcao, dataAtual, horaEntrada, horaSaida) VALUES (?,?,?,?,?,?)";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, inserirdados.getNomeDoFuncionario());
			stmt.setString(2, inserirdados.getSetor());
			stmt.setString(3, inserirdados.getFuncao());
			stmt.setDate(4, new java.sql.Date(inserirdados.getData().getTime()));
			stmt.setString(5, inserirdados.getHoraEntrada());
			stmt.setString(6, inserirdados.getHoraSaida());
		

			stmt.execute();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	
	
}
