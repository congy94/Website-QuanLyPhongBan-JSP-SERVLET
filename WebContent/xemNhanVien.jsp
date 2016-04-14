<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Model.Bean.NhanVien"%>
<%@page import="Model.Bean.PhongBan"%>
<%
	ArrayList<NhanVien> nhanVienList = null;
	ArrayList<PhongBan> phongBanList = null;
	nhanVienList = (ArrayList<NhanVien>) request.getAttribute("NhanVien");
	phongBanList = (ArrayList<PhongBan>) request.getAttribute("PhongBan");
	NhanVien nv = new NhanVien();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<div class="header-nhanvien" width="100%" height="100px"
		style="background-color: #1abc9c; margin-bottom: 5px;">
		<button class="btn btn-default" style="border-radius: 0px;"
			data-toggle="modal" data-target="#themNhanVien">Thêm nhân
			viên</button>
	</div>
	<table class="table table-bordered">
		<tr>
			<td><b>STT</b></td>
			<td><b>Mã nhân viên</b></td>
			<td><b>Tên nhân viên</b></td>
			<td><b>Dịa chỉ</b></td>
			<td><b>Số điện thoại</b></td>
			<td><b>Phòng ban</b></td>
			<td><b>Ngày sinh</b></td>
			<td><b>Thao tác</b></td>
		</tr>
		<%
			for (int i = 0; i < nhanVienList.size(); i++) {
		%>
		<tr>
			<td><%=i + 1%></td>
			<td><%=nhanVienList.get(i).getMaNhanVien()%></td>
			<td><%=nhanVienList.get(i).getTenNhanVien()%></td>
			<td><%=nhanVienList.get(i).getDiaChiNhanVien()%></td>
			<td><%=nhanVienList.get(i).getSoDienThoai()%></td>
			<td><%=nhanVienList.get(i).getPhongBan()%></td>
			<td><%=nhanVienList.get(i).getNgaySinh()%></td>
			<td><a
				href="QuanLyHeThong?act=xoaNhanVien&maNhanVien=<%=nhanVienList.get(i).getMaNhanVien()%>">Xóa</a>|<a
				href="#"
				onclick="javascript:document.getElementById('suaNhanVienFrame').src='QuanLyHeThong?act=suaNhanVien&maNhanVien=<%=nhanVienList.get(i).getMaNhanVien()%>';"
				data-toggle="modal" data-target="#suaNhanVien">Sửa</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<!-- Hiện bảng thêm nhân viên -->
	<div class="modal fade" id="themNhanVien" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Thêm nhân viên</h4>
				</div>
				<form action="QuanLyHeThong?act=luuNhanVien" method="post">
					<div class="modal-body">
						<div class="form-group">
							<label>Mã nhân viên:</label> <input type="text"
								class="form-control" name="maNhanVien"
								placeholder="Mã nhân viên">
						</div>
						<div class="form-group">
							<label>Tên nhân viên:</label> <input type="text"
								class="form-control" name="tenNhanVien"
								placeholder="Tên nhân viên">
						</div>
						<div class="form-group">
							<label>Dịa chỉ nhân viên:</label> <input type="text"
								class="form-control" name="diaChi"
								placeholder="Địa chỉ nhân viên">
						</div>
						<div class="form-group">
							<label>Ngày sinh:</label> <input type="text" class="form-control"
								name="ngaySinh" placeholder="Ngày sinh">
						</div>
						<div class="form-group">
							<label>Số điện thoại:</label> <input type="text"
								class="form-control" name="soDienThoai"
								placeholder="Số điện thoại">
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
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
						<button type="submit" class="btn btn-primary">Thêm nhân
							viên</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Hiện bảng thêm nhân viên -->
	<div class="modal fade" id="suaNhanVien" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" onclick="javascript:location.reload();"
						class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Thêm nhân viên</h4>
				</div>
				<iframe src="" id="suaNhanVienFrame" style="border: none;"
					width="100%" height="300px"></iframe>
				<div class="modal-footer">
					<button type="button" class="btn btn-default"
						onclick="javascript:location.reload();" data-dismiss="modal">Cancel</button>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>