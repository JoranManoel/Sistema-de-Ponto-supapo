package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ClassesBasicasDoPonto.TabelaFuncionario;
import conexao.ConnectionFactory;

public class CriarTabelaFuncionarioDao {
	
private Connection connection;
	
	public  CriarTabelaFuncionarioDao () {
		try {
			
			this.connection = new ConnectionFactory().getConnection();
				
				} catch (SQLException e) {
						
			throw new RuntimeException(e);
					
			}
				}
	public void Criar(TabelaFuncionario tabela) {
		
		try {
					
		String sql = "CREATE TABLE " + tabela.getNomeDaTabela() +"(matricula INT AUTO_INCREMENT PRIMARY KEY,"
				+ "nomeFuncionario VARCHAR(30) NOT NULL,"
				+ "setor VARCHAR(30) NOT NULL,"
				+ "funcao VARCHAR(30) NOT NULL,"
				+ "dataAtual Date NOT NULL,"
				+ "horaEntrada VARCHAR(11) NOT NULL,"
				+ "horaSaida VARCHAR(11) NOT NULL"
				+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

					
		PreparedStatement stmt = connection.prepareStatement(sql);

			
		
					
	
					
		

					
		stmt.execute();
					
		connection.close();
				} 
		catch (SQLException e) {
					
		throw new RuntimeException(e);
				
		}
			}


}
