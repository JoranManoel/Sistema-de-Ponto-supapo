package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import java.time.LocalDate;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ClassesBasicasDoPonto.Relatorio;
import Dao.GerarRelatorioDao;
@WebServlet("/gerar")
public class RelatorioMensalDoPontoServlet extends HttpServlet {

	private static final long serialVersionUID = -755116439394162858L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String NomeFuncionario = request.getParameter("nomeFuncionario");
		String setor = request.getParameter("setor");
		String funcao = request.getParameter("funcao");
		String dataString = request.getParameter("data");
	
		String[] dataSeparada = dataString.split("/");
		
		LocalDate data = LocalDate.of(Integer.parseInt(dataSeparada[2]), Integer.parseInt(dataSeparada[1]), Integer.parseInt(dataSeparada[0]));
		
	Relatorio r = new Relatorio ();
	r.setNomeDoFuncionario(NomeFuncionario);
	r.setSetor(setor);
	r.setFuncao(funcao);
	r.setData(data);
		
		
		
		GerarRelatorioDao Dao = new GerarRelatorioDao();
	
			List<Relatorio> lista = Dao.ListarRelatorio(NomeFuncionario);
				
			
			
			
			
			
			
			
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<body>");
				out.println("<h1>Espelho de Ponto</h1>");
				
				
				
					out.println("<table>");
					out.println("<tr>");
					out.println("<td  bgcolor='#7FFFD4'>Nome do Funcionario</td>");
					out.println("<td  bgcolor='#7FFFD4'>Função</td>");
					out.println("<td bgcolor='#7FFFD4'>Sertor</td>");
					out.println("</tr>");
						
								for (Relatorio dados01 : lista) {
									
									out.println("<tr>");
									out.println("<td  bgcolor='#FFEBCD'>"+dados01.getNomeDoFuncionario()+"</td>");
									out.println("<td  bgcolor='#FFEBCD'>"+dados01.getFuncao()+"</td>");
									out.println("<td bgcolor='#FFEBCD'>"+dados01.getSetor()+"</td>");
									out.println("</tr>");
								}
								
					out.println("</table>");
					
						
					out.println("<table>");
					out.println("<tr>");
					out.println("<td bgcolor='#7FFFD4'>Data</td>");
					out.println("<td bgcolor='#7FFFD4'>Hora da Entrada</td>");
					out.println("<td bgcolor='#7FFFD4'>Hora da Saida</td>");
				    out.println("</tr>");
						
								for (Relatorio dados02 : lista) {
								out.println("<tr>");
									out.println("<td bgcolor='#FFEBCD'>"+ dados02.getData() +"</td>");
									out.println("<td bgcolor='#FFEBCD'>"+ dados02.getHoraEntrada() +"</td>");
									out.println("<td bgcolor='#FFEBCD'>"+ dados02.getHoraSaida() +"</td>");
									out.println("</tr>");
								}
								
					out.println("</table>");
						
						
				
				out.println("</body>");
				out.println("</html>");


			
				
				
				
		
		
		
		
	}

}
