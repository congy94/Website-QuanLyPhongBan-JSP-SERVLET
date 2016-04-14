<%@page import="Model.BO.NhanVienBO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Model.Bean.PhongBan"%>
<%
	ArrayList<PhongBan> phongBanList = new ArrayList<PhongBan>();
	phongBanList = (ArrayList<PhongBan>) request.getAttribute("PhongBan");
	NhanVienBO nhanvienBO = new NhanVienBO();
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
			data-toggle="modal" data-target="#themPhongBan">Thêm phòng
			ban</button>
	</div>
	<table class="table table-bordered">
		<tr>
			<td><b>STT</b></td>
			<td><b>Mã phòng ban</b></td>
			<td><b>Tên phòng ban</b></td>
			<td><b>Số lượng nhân viên</b></td>
			<td><b>Thao tác</b></td>
		</tr>
		<%
			for (int i = 0; i < phongBanList.size(); i++) {
		%>
		<tr>
			<td><%=i + 1%></td>
			<td><%=phongBanList.get(i).getMaPhongBan()%></td>
			<td><%=phongBanList.get(i).getTenPhongBan()%></td>
			<td><%=nhanvienBO.soLuongNhanVien(phongBanList.get(i).getTenPhongBan())%></td>
			<td><a
				href="QuanLyHeThong?act=xemNhanVienPhongBan&locPhongBan=<%=phongBanList.get(i).getTenPhongBan()%>">Xem</a>|<a
				href="QuanLyHeThong?act=xoaPhongBan&maPhongBan=<%=phongBanList.get(i).getMaPhongBan()%>&tenPhongBan=<%=phongBanList.get(i).getTenPhongBan()%>">Xóa</a>|<a
				href="#"
				onclick="javascript:document.getElementById('suaPhongBanFrame').src='QuanLyHeThong?act=suaPhongBan&maPhongBan=<%=phongBanList.get(i).getMaPhongBan()%>';"
				data-toggle="modal" data-target="#suaPhongBan">Sửa</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<!-- Hiện bảng thêm phòng ban -->
	<div class="modal fade" id="themPhongBan" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Thêm phòng ban</h4>
				</div>
				<form action="QuanLyHeThong?act=themPhongBan" method="post">
					<div class="modal-body">
						<div class="form-group">
							<label>Mã phòng ban:</label> <input type="text"
								class="form-control" name="maPhongBan"
								placeholder="Mã phòng ban">
						</div>
						<div class="form-group">
							<label>Tên phòng ban:</label> <input type="text"
								class="form-control" name="tenPhongBan"
								placeholder="Tên phòng ban">
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
						<button type="submit" class="btn btn-primary">Thêm phòng
							ban</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Hiện bảng sửa phòng ban -->
	<div class="modal fade" id="suaPhongBan" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" onclick="javascript:location.reload();" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Thêm phòng ban</h4>
				</div>
				<div class="modal-body">
					<iframe src="" id="suaPhongBanFrame" style="border: none;"
						width="100%" height="300px"></iframe>
				</div>
				<div class="modal-footer">
					<button type="button" onclick="javascript:location.reload();" class="btn btn-default" data-dismiss="modal">Cancel</button>
				</div>
				</form>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>