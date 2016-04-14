<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Model.Bean.PhongBan"%>
<% PhongBan pb = new PhongBan();
	pb = (PhongBan)request.getAttribute("PHONGBAN");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<form action="QuanLyHeThong?act=updatePhongBan&maPhongBan=<%=pb.getMaPhongBan()%>&tenPhongBanCu=<%=pb.getTenPhongBan()%>" method="post">
		<div class="modal-body">
			<div class="form-group">
				<label>Mã phòng ban:</label> <input type="text" class="form-control"
					name="maPhongBan" value="<%=pb.getMaPhongBan()%>" disabled>
			</div>
			<div class="form-group">
				<label>Tên phòng ban:</label> <input type="text"
					class="form-control" name="tenPhongBan" value="<%=pb.getTenPhongBan()%>">
			</div>
		</div>
		<div class="modal-footer">
			<button type="submit" class="btn btn-primary">Sửa phòng ban</button>
		</div>
	</form>
</body>
</html>