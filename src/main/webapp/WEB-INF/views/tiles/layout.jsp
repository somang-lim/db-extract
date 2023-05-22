<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/main/layout.css">
</head>
<body>
	<table id="layout">
		<tr class="layoutHeader">
			<td>
				<tiles:insertAttribute name="header" />
			</td>
		</tr>
		<tr height="90%">
			<td class="body">
				<tiles:insertAttribute name="body" />
			</td>
		</tr>
		<tr class="layoutFooter">
			<td>
				<tiles:insertAttribute name="footer" />
			</td>
		</tr>
	</table>
</body>
</html>