<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Chương trình quản lý phòng ban</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
  <div class="container">
    <div id="header">
      <h1>CHƯƠNG TRÌNH QUẢN LÝ PHÒNG BAN</h1>
    </div>
    <div id="content">
    <div class="container">
      <div class="row">
      
        <div class="sidebarleft col-sm-2">
          <a href="" class="btn btn-success btn-block">Trang chủ</a>
          <a href="QuanLyHeThong?act=xemNhanVien" class="btn btn-default btn-block" target="_main">Xem nhân viên</a>
          <a href="QuanLyHeThong?act=xemPhongBan"  class="btn btn-default btn-block" target="_main">Xem phòng ban</a>
          <a href="timkiem.html"  class="btn btn-default btn-block" target="_main">Tìm kiếm</a>
          <a href="trogiup.html"  class="btn btn-default btn-block"target="_main">Trợ giúp chương trình</a>
        </div>
        <div class="content-main col-sm-8" style="margin-right:5px">  
          <iframe src="trangChu.jsp" name="_main" style="border:none;" width="100%" height="500px"></iframe>
        </div>
        <div class="sidebarright col-sm-2" style="width: 156px;">
        </div>
      </div>
    </div>
    </div>
    <div id="footer" style="margin-top:5px">
      <b>copyright © 2016 nguyễn công y</b>
    </div>
  </div>
  <script
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
</body>
</html>