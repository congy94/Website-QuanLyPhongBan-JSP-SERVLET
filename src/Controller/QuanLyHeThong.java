package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BO.NhanVienBO;
import Model.BO.PhongBanBO;
import Model.Bean.NhanVien;
import Model.Bean.PhongBan;

/**
 * Servlet implementation class Q
 */
@WebServlet("/QuanLyHeThong")
public class QuanLyHeThong extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuanLyHeThong() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String act = request.getParameter("act");
		switch (act) {
		case "xemNhanVien": {
			NhanVienBO nhanVienBO = new NhanVienBO();
			PhongBanBO phongBanBO = new PhongBanBO();
			ArrayList<NhanVien> nhanVienList = new ArrayList<NhanVien>();
			ArrayList<PhongBan> phongBanList = new ArrayList<PhongBan>();
			nhanVienList = nhanVienBO.getAll();
			phongBanList = phongBanBO.getAll();
			request.setAttribute("NhanVien", nhanVienList);
			request.setAttribute("PhongBan", phongBanList);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/xemNhanVien.jsp");
			dispatcher.forward(request, response);
			break;
		}
		case "luuNhanVien": {

			NhanVien nv = new NhanVien();
			nv.setMaNhanVien(request.getParameter("maNhanVien"));
			nv.setTenNhanVien(request.getParameter("tenNhanVien"));
			nv.setDiaChiNhanVien(request.getParameter("diaChi"));
			nv.setNgaySinh(request.getParameter("ngaySinh"));
			nv.setPhongBan(request.getParameter("phongBan"));
			nv.setSoDienThoai(request.getParameter("soDienThoai"));
			NhanVienBO nhanVienBO = new NhanVienBO();
			nhanVienBO.insert(nv);
			response.sendRedirect("QuanLyHeThong?act=xemNhanVien");
			break;
		}
		case "xemPhongBan": {
			PhongBanBO phongBanBO = new PhongBanBO();
			ArrayList<PhongBan> phongBanList;
			phongBanList = phongBanBO.getAll();
			request.setAttribute("PhongBan", phongBanList);
			request.getRequestDispatcher("/xemPhongBan.jsp").include(request, response);
			break;
		}
		case "themPhongBan": {
			PhongBan pb = new PhongBan();
			pb.setMaPhongBan(request.getParameter("maPhongBan"));
			pb.setTenPhongBan(request.getParameter("tenPhongBan"));
			PhongBanBO phongBanBO = new PhongBanBO();
			phongBanBO.insert(pb);
			response.sendRedirect("QuanLyHeThong?act=xemPhongBan");
			break;
		}
		case "xoaNhanVien": {
			String maNhanVien = (String) request.getParameter("maNhanVien");
			System.out.println(maNhanVien);
			NhanVienBO nhanvienBO = new NhanVienBO();
			nhanvienBO.delete(maNhanVien);
			response.sendRedirect("QuanLyHeThong?act=xemNhanVien");
			break;
		}
		case "suaNhanVien": {
			String maNhanVien = request.getParameter("maNhanVien");
			maNhanVien.trim();
			NhanVien nhanvien = new NhanVien();
			NhanVienBO nhanvienBO = new NhanVienBO();
			nhanvien = nhanvienBO.getByID(maNhanVien);
			request.setAttribute("NHANVIEN", nhanvien);
			request.getRequestDispatcher("/suaNhanVien.jsp").include(request, response);
			break;
		}
		case "updateNhanVien": {
			NhanVien nv = new NhanVien();
			nv.setMaNhanVien(request.getParameter("maNhanVien1"));
			nv.setTenNhanVien(request.getParameter("tenNhanVien"));
			nv.setDiaChiNhanVien(request.getParameter("diaChi"));
			nv.setNgaySinh(request.getParameter("ngaySinh"));
			nv.setPhongBan(request.getParameter("phongBan"));
			System.out.println(nv.getPhongBan());
			nv.setSoDienThoai(request.getParameter("soDienThoai"));
			NhanVienBO nhanvienBO = new NhanVienBO();
			nhanvienBO.update(nv);
			request.getRequestDispatcher("/updateThanhCong.jsp").include(request, response);
			break;
		}
		case "xoaPhongBan": {
			String maPhongBan = request.getParameter("maPhongBan");
			String tenPhongBan = request.getParameter("tenPhongBan");
			PhongBanBO phongbanBO = new PhongBanBO();
			phongbanBO.delete(maPhongBan);
			NhanVienBO nhanvienBO = new NhanVienBO();
			ArrayList<NhanVien> nhanVienList = new ArrayList<NhanVien>();
			nhanVienList = nhanvienBO.getByPhongBan(tenPhongBan);
			for (int i = 0; i < nhanVienList.size(); i++) {
				nhanvienBO.delete(nhanVienList.get(i).getMaNhanVien());
			}
			response.sendRedirect("QuanLyHeThong?act=xemPhongBan");
			break;
		}
		case "xemNhanVienPhongBan": {
			String locPhongBan = request.getParameter("locPhongBan");
			NhanVienBO nhanvienBO = new NhanVienBO();
			PhongBanBO phongBanBO = new PhongBanBO();
			ArrayList<NhanVien> nhanVienList = new ArrayList<NhanVien>();
			ArrayList<PhongBan> phongBanList = new ArrayList<PhongBan>();
			nhanVienList = nhanvienBO.getByPhongBan(locPhongBan);
			phongBanList = phongBanBO.getAll();
			request.setAttribute("NhanVien", nhanVienList);
			request.setAttribute("PhongBan", phongBanList);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/xemNhanVien.jsp");
			dispatcher.forward(request, response);
			break;
		}
		case "suaPhongBan":{
			String maPhongBan = request.getParameter("maPhongBan");
			maPhongBan.trim();
			PhongBan phongban = new PhongBan();
			PhongBanBO phongbanBO = new PhongBanBO();
			phongban = phongbanBO.getByID(maPhongBan);
			request.setAttribute("PHONGBAN", phongban);
			request.getRequestDispatcher("/suaPhongBan.jsp").include(request, response);
			break;
		}
		case "updatePhongBan":{
			String tenPhongBan = request.getParameter("tenPhongBan");
			System.out.println(request.getParameter("tenPhongBanCu"));
			PhongBan pb = new PhongBan();
			pb.setMaPhongBan(request.getParameter("maPhongBan"));
			pb.setTenPhongBan(request.getParameter("tenPhongBan"));
			PhongBanBO phongbanBO = new PhongBanBO();
			phongbanBO.update(pb);
			NhanVienBO nhanvienBO = new NhanVienBO();
			ArrayList<NhanVien> nhanvienList = new ArrayList<NhanVien>();
			nhanvienList = nhanvienBO.getByPhongBan(request.getParameter("tenPhongBanCu"));
			for(int i=0;i<nhanvienList.size();i++){
				nhanvienList.get(i).setPhongBan(tenPhongBan);
				nhanvienBO.update(nhanvienList.get(i));
			}
			request.getRequestDispatcher("/updateThanhCong.jsp").include(request, response);
			break;
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		doGet(request, response);
	}

}
