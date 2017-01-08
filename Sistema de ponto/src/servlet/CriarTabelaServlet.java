package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ClassesBasicasDoPonto.TabelaFuncionario;
import Dao.CriarTabelaFuncionarioDao;


@WebServlet("/criarTabela")
public class CriarTabelaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6415962640590773014L;
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		// Passo 1 - obter dados do html e guardar esses dados em vari√°veis
		
				String nomeTabela = request.getParameter("nomeDaTabela");
				String nomeTabela2 = nomeTabela.replaceAll(" ", "");
			
	
TabelaFuncionario tabela = new TabelaFuncionario();

tabela.setNomeDaTabela(nomeTabela2);

CriarTabelaFuncionarioDao criar = new CriarTabelaFuncionarioDao();

criar.Criar(tabela);



PrintWriter out = response.getWriter();
out.println("<html>");
out.println("<body>");
out.println("<h1>Atabela com o Nome : " + tabela.getNomeDaTabela() +  "  foi criada com sucesso</h1>");
out.println("<br>");

out.println("Agora insira os dados desse novo funcionario");

out.println("<br>");
    out.println("<form action='inserir' method='post'>");
    out.println("Nome do funcion·rio: <input type='text' name='nomeFuncionario' value='"+tabela.getNomeDaTabela()+"'  readonly='readonl'> <br>");
		out.println("Setor: <input type='text'name='setor'> <br>");
			out.println("Func„o: <input type='text'name='funcao'><br> ");
				out.println("<input type='submit' value='inserir'>");
					out.println("</form>");
out.println("</body>");
out.println("</html>");




}
}