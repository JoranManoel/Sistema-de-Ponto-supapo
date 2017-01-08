package Dao;

import java.sql.Connection;
import java.sql.SQLException;

import ClassesBasicasDoPonto.DadosFuncionarios;
import conexao.ConnectionFactory;

import java.sql.PreparedStatement;


public class SaidaPontoDao {
	
	private Connection connection;

	public SaidaPontoDao() {

		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void saida(DadosFuncionarios baterSaida) {
		
		try {

			String sql = "UPDATE "+baterSaida.getNomeDoFuncionario()+" SET horaSaida= ? WHERE dataAtual= ?";
				PreparedStatement stmt = connection.prepareStatement(sql);
					stmt.setString(1, baterSaida.getHoraSaida() );
						stmt.setDate(2, new java.sql.Date(baterSaida.getData().getTime()));
							stmt.execute();
			
							connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
