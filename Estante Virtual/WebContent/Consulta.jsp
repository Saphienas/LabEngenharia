<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cadastro de Exemplares</title>
		
	     <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	     <link type="text/css" rel="stylesheet" href="css/materialize.css"/>
	     <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		
</head>
<body>
	<c:import url="cabecalho.html"></c:import>
	<jsp:useBean id="dao" class="Services.ExemplarDao" />
	<h1 class="center-align">Coleção</h1>
  	
  	<div>
  	<table class="highlight responsive-table">
   	    <thead>
          <tr>
              <th>Nome</th>
              <th>Edição</th>
              <th>Preço</th>
              <th>Editora</th>
              <th>Autor</th>
              <th>Restante</th>
              <th>Ações</th>
          </tr>
        </thead>
        <tbody>
			<c:forEach var="exemplar" items="${dao.lista}">
	     		<tr>
			     	<td>${exemplar.nome}</td>
			     	<td>${exemplar.edicao}</td>	
			     	<td>${exemplar.preco}</td>
			     	<td>${exemplar.editora}</td>
			     	<td>${exemplar.autor}</td>					     	
				    <td>${((exemplar.paginasTotais - exemplar.paginasAtuais)/exemplar.paginasTotais)*100}%</td>
				    <td><a href="mvc?logica=DeletaExemplarLogic&id=${exemplar.id}">Finalizar</a>
				    	<a href="mvc?logica=DeletaExemplarLogic&id=${exemplar.id}">Alterar</a></td>
		     	</tr>
	 		</c:forEach>
 		</tbody> 	
	</table>
	</div>
	<br>
	<br>
	<c:import url="rodape.html"></c:import>
</body>
</html>