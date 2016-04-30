<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="br.ufpr.modelo.Contato"%>
<%@page import="br.ufpr.dao.ContatoDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Contatos</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<br>
	<center>
		<c:import url="cabecalho.jsp"></c:import>
	</center>
	<br>
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

					</tr>

					<c:forEach var="contato" items="${dao.lista}">
						<tr>
							<td>${contato.nome}</td>
							<td>${contato.endereco}</td>

							<td><c:choose>
									<c:when test="${not empty contato.email}">
										<a href="mailto:${contato.email}">${contato.email}</a>
									</c:when>
									<c:otherwise>
										E-mail não informado!
									</c:otherwise>
								</c:choose></td>

							<td> <fmt:formatDate value="${contato.dataNascimento.time}" pattern ="dd/MM/yyyy"></fmt:formatDate></td>
							<td>
								<button id="${contato.ID}" class="btn btn-info"
									onclick="window.location.href = 'alterar-contato.jsp?id=${contato.ID}';">
									Alterar</button>
							</td>

						</tr>
					</c:forEach>
				</table>

			</div>
			<center>
				<button class="btn btn-info"
					onclick="window.location.href = 'adiciona-contato.jsp';">
					Adicionar Contato</button>
			</center>
		</div>

		<c:import url="rodape.jsp"></c:import>
</body>
</html>