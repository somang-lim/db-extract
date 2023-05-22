<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Oracle</title>

<link rel="stylesheet" href="../css/main/table.css">
<script type="text/javascript" src="../js/oracle/ORCLnav.js"></script>
<script type="text/javascript" src="../js/oracle/ORCLtable.js"></script>
<script type="text/javascript" src="../js/oracle/ORCLFileDownload.js"></script>
</head>
<body>
	<main>
		<div class="navbar">
			<div class="dbList">
				<div class="p-3 bg-white" style="width: 280px;">
					<!-- DB 스키마 & 테이블 정보 -->
					<div id="navList"></div>
				</div>
			</div>
		</div>
		<div class="container tableInfo">
			<!-- DB 테이블 정보 -->
			<div id="showTable">
				<div class="notice">
					<h2><strong>ORACLE</strong></h2>
					<br/>
					<h3><strong>← 옆에 테이블을 선택해 주세요.</strong></h3>
				</div>
			</div>
		</div>
	</main>
</body>
</html>