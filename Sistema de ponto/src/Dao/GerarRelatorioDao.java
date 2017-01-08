package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import ClassesBasicasDoPonto.Relatorio;

import conexao.ConnectionFactory;

public class GerarRelatorioDao {


	private Connection connection;

	public GerarRelatorioDao() {

		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

	
	
	public List<Relatorio> ListarRelatorio(String NomeFuncionario) throws SQLException{

		Relatorio d = new Relatorio();
		PreparedStatement stmt = connection.prepareStatement("SELECT FROM "+ d.getNomeDoFuncionario());
      
        ResultSet rs = stmt.executeQuery();
        
       List<Relatorio> relatorio = new ArrayList<Relatorio>();
       
        while(rs.next()){
            
        	Relatorio pegar = new Relatorio();
        	pegar.setMatricula(rs.getInt("matricula"));
        	pegar.setNomeDoFuncionario(rs.getString("NomeDoFuncionario"));
        	pegar.setSetor("setor");
        	pegar.setFuncao("funcao");
        	pegar.setData(rs.getDate("dataAtual").toLocalDate());
        	pegar.setHoraEntrada(rs.getString("horaEntrada"));
        	pegar.setHoraSaida(rs.getString("horaSaida"));
        	
            //Adicionando Valores a lista
        	relatorio.add(pegar);
        }
        rs.close();
        stmt.close();
        return relatorio;
    } */
}
