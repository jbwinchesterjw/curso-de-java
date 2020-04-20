<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- serve para repitir codigos html so importa do pom.xml -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de produtos</title>
<link href="/CSS/Style.css" rel="stylesheet"/>
</head>
<body>
	<form method="post" action="/apex-ecommerce/produtos">
		<div>
			<label for="title">Titulo</label> <input type="text" name="title"
				id="title" />
		</div>
		<div>
			<label for="deion">Descrição</label>
			<textarea rows="10" cols="20" name="description" id="description">
            </textarea>
		</div>
		<div>
			<label for="pages">Número de paginas</label> <input type="text"
				name="pages" id="pages" />
		</div>

		<c:forEach items="${ types }" var="bookType" varStatus="status">
			<div>
				<label for="price_${ bookType }">${ bookType }</label> <input
					type="text" name="prices[${ status.index }].value" /> <input
					type="hidden" name="prices[${ status.index }].bookType"
					value="${ bookType }" />
			</div>
		</c:forEach>

		<div>
			<input type="submit" value="Enviar">
		</div>
	</form>
</body>
</html>