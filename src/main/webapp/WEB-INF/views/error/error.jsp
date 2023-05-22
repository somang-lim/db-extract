<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${code} ERROR</title>
</head>
<body class="d-flex h-100 text-center">
	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
	  <main class="px-3">
	    <h1><strong>${code}</strong></h1>
	    <p class="lead">${msg}</p>
	    <p>${timestamp}</p>
	    <p class="lead">
	      <a href="/" class="btn btn-lg fw-bold border-dark">홈으로 이동</a>
	    </p>
	  </main>
	</div>
</body>
</html>