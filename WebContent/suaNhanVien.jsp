<%@page import="Model.BO.PhongBanBO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Model.Bean.NhanVien"%>
<%@page import="Model.Bean.PhongBan"%>
<% NhanVien nv = new NhanVien();
	nv = (NhanVien)request.getAttribute("NHANVIEN");
	ArrayList<PhongBan> phongBanList = new ArrayList<PhongBan>();
	PhongBanBO phongbanBO = new PhongBanBO();
	phongBanList = phongbanBO.getAll();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<form action="QuanLyHeThong?act=updateNhanVien&maNhanVien1=<%=nv.getMaNhanVien()%>" method="post">
		<div class="modal-body">
			<div class="form-group">
				<label>Mã nhân viên:</label> <input type="text" class="form-control"
					name="maNhanVien" value="<%=nv.getMaNhanVien()%>" disabled>
			</div>
			<div class="form-group">
				<label>Tên nhân viên:</label> <input type="text"
					class="form-control" name="tenNhanVien" value="<%=nv.getTenNhanVien()%>">
			</div>
			<div class="form-group">
				<label>Dịa chỉ nhân viên:</label> <input type="text"
					class="form-control" name="diaChi" value="<%=nv.getDiaChiNhanVien()%>">
			</div>
			<div class="form-group">
				<label>Ngày sinh:</label> <input type="text" class="form-control"
					name="ngaySinh" value="<%=nv.getNgaySinh()%>">
			</div>
			<div class="form-group">
				<label>Số điện thoại:</label> <input type="text"
					class="form-control" name="soDienThoai" value="<%=nv.getSoDienThoai()%>">
			</div>
			<label>Phòng ban:</label> <select class="form-control"
				name="phongBan">
				<%
					for (int i = 0; i < phongBanList.size(); i++) {
				%>
				<option><%=phongBanList.get(i).getTenPhongBan()%></option>
				<%
					}
				%>
			</select>
		</div>
		<div class="modal-footer">
			<button type="submit" class="btn btn-primary">Sửa nhân viên</button>
		</div>
	</form>
</body>
</html>