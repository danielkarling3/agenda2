<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.ufpr.modelo.Contato"%>
<%@page import="br.ufpr.dao.ContatoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>

</head>
<body>

	<jsp:useBean id="dao" class="br.ufpr.dao.ContatoDao"></jsp:useBean>
	<div class="container">
		<div class="panel panel-info">
			<div class="panel-heading">
				<center>Listar Contatos</center>
			</div>
			<div class="panel-info">
				<table class="table">
					<tr>
						<td>Nome:</td>
						<td>Endereço:</td>
						<td>Email:</td>
						<td>Data de Nascimento:</td>
						<td>Alterar</td>
					</tr>

					<%
						for (Contato r : dao.getLista()) {
					%>
					<tr>
						<td>
							<%
								out.print("  " + r.getNome() + " ");
							%>
						</td>
						<td>
							<%
								out.print("  " + r.getEndereco() + " ");
							%>
						</td>
						<td>
							<%
								out.print("  " + r.getEmail() + " ");
							%>
						</td>
						<td>
							<%
								out.print("  " + new SimpleDateFormat("dd/MM/yyyy").format(r.getDataNascimento().getTime()) + " ");
							%>
						</td>
						<td>
							<button id="<%=r.getID()%>" class="btn btn-info"
								onclick="window.location.href = 'alterar-contato.jsp?id=<%=r.getID()%>';">
								Alterar</button>
						</td>
					</tr>
					<%
						}
					%>

				</table>

			</div>
			<center>
				<button class="btn btn-info"
					onclick="window.location.href = 'adiciona-contato.html';">
					Adicionar Contato</button>
			</center>
		</div>
	</div>







</body>
</html>