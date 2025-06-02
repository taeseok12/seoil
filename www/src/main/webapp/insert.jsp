<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container-fluid">
	<form action="/insert" method="post">
	<h3 class="h3">전화번호부 입력</h3>
		<div>
			<label class = "form-label" for="name">이름</label>
			<input class="form-control" type="text" id="name" name="name" required>
		</div>
		<div>
			<label class = "form-label" for="hp">전화번호</label>
			<input class="form-control" type="text" id="hp" name="hp" required>
		</div>
		<div>
			<label class = "form-label" for="email">이메일</label>
			<input class="form-control" type="email" id="email" name="email" required>
		</div>
		<div>
			<label class = "form-label" for="memo">메모</label>
			<input class="form-control bg-primary text-white" type="text" id="memo" name="memo" required>
		</div>
		<input type="sumit" value="전화번호부입력">
	</form>
</div>
</body>
</html>