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
import Dao.InserirDadosDoFuncionarioDao;

@WebServlet("/inserir")
public class InserirDadosNovoFuncionarioServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8257215062006006256L;
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		// Passo 1 - obter dados do html e guardar esses dados em variáveis

				String nome = request.getParameter("nomeFuncionario");
				
				String setorFuncionario = request.getParameter("setor");
	
				String funcaoFuncionario = request.getParameter("funcao");
	
				Date dataAtual = new Date();
				
				//---------hora ------------------//
				 GregorianCalendar zz = new GregorianCalendar();  
				    zz.setTime(new Date());  
				    SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss"); 
				    hora.format(zz.getTime()); 
				  
			
			
				
				    DadosFuncionarios inserirdados = new DadosFuncionarios();
				
				inserirdados.setNomeDoFuncionario(nome);
				inserirdados.setFuncao(funcaoFuncionario);
				inserirdados.setSetor(setorFuncionario);
				inserirdados.setData(dataAtual);
				inserirdados.setHoraEntrada(hora.format(zz.getTime()));
				inserirdados.setHoraSaida(hora.format(zz.getTime()));
				
	
	String nomeSemEspaco = inserirdados.getNomeDoFuncionario();
				String nomeDoFuncionarioSemEspaco = nomeSemEspaco.replaceAll(" ", "");
	
	InserirDadosDoFuncionarioDao salvar = new InserirDadosDoFuncionarioDao();
	
	salvar.salvar(inserirdados);
	
	PrintWriter out = response.getWriter();
	out.println("<html>");
	out.println("<body>");
	out.println("<h1>Os Dados do Funcionario: " + inserirdados.getNomeDoFuncionario()+  "  foi inserido com sucesso junto com sua Entrada no ponto</h1>");
	out.println("<br>");
	out.println("<h1>bater a saida no ponto</h1>");
	out.println("<br>");
   
				out.println("<form action='saida?nome="+inserirdados.getNomeDoFuncionario()+"' method='post'>");
					out.println("<input type='submit' value='Bater Saida'>");
						out.println("</form>"); 

	out.println("</body>");
	out.println("</html>");

	
	
	
	
	}
	

}
