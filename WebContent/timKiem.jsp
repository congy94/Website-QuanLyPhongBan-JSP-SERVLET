<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="text-align: center; padding-top: 50px;">
	<form class="form-inline" action="QuanLyHeThong?act=timkiem" method="post">
		<div class="form-group">
			<select class="form-control" name="timkiemtheo">
				<option>Nhân viên</option>
				<option>Phòng ban</option>
			</select>
		</div>
		<div class="form-group">
			<input type="text" class="form-control" name="tukhoatimkiem"
				placeholder="Nhập từ khóa">
		</div>
		<button type="submit" class="btn btn-default">Tìm kiếm</button>
	</form>
</body>
</html>