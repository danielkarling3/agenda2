package br.ufpr.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufpr.dao.ContatoDao;
import br.ufpr.modelo.Contato;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdicionaContatoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataNascimentoTexto = request.getParameter("dataNascimento");

		PrintWriter out = response.getWriter();

		System.out.println("criar\n");
		
		
		out.println("Nome : " + nome);
		out.println("Email : " + email);
		out.println("Endereco : " + endereco);
		out.println("Data de Nascimento : " + dataNascimentoTexto);
		

		System.out.println("data");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


		Calendar dataNascimento = Calendar.getInstance();
		try {
			dataNascimento.setTime(sdf.parse(dataNascimentoTexto));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}


		System.out.println("gravar\n");

		System.out.println(sdf.format(dataNascimento.getTime()));
		
		gravarBanco(nome, email, endereco, dataNascimento);
	}

	protected void gravarBanco(String nome, String email, String endereco, Calendar dataNascimento) {
		Contato contato = new Contato(nome, email, endereco, dataNascimento);
		ContatoDao dao = new ContatoDao();

		System.out.println("novo DAO");
		dao.adiciona(contato);
		System.out.println(contato.getNome());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
