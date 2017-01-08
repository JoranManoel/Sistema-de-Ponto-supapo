package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ClassesBasicasDoPonto.DadosFuncionarios;
import Dao.SaidaPontoDao;

@WebServlet("/saida")
public class SaidaDePontoServlet extends HttpServlet{

	private static final long serialVersionUID = -1196517520066883922L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// tenho que retirar os espaços vazios da string nomeDoFuncionario antes de da um set se não quando for no dao vai dar erro
		String nome = request.getParameter("nome");
		
		
		
		//---------hora em java util------------------//
		Date dataAtual = new Date();
		
		//---------hora em String------------------//
		 	GregorianCalendar zz = new GregorianCalendar();  
		 		zz.setTime(new Date());  
		 			SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss"); 
		 				hora.format(zz.getTime()); 
		
		
		DadosFuncionarios baterSaida = new DadosFuncionarios();
			baterSaida.setNomeDoFuncionario(nome);
				baterSaida.setData(dataAtual);
					baterSaida.setHoraSaida(hora.format(zz.getTime()));
		
		SaidaPontoDao atualizar = new  SaidaPontoDao();
			atualizar.saida(baterSaida);
		
		
		PrintWriter out = response.getWriter();
			out.println("<html>");
				out.println("<body>");
					out.println("<h1>O Funcionario Largou</h1>");
						out.println("</body>");
							out.println("</html>");
		
		
	}
}
