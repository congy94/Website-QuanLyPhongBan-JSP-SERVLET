package Model.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Bean.NhanVien;
import Model.DAO.ConnectDB;
import Model.DAO.NhanVienDAO;

public class NhanVienBO implements NhanVienDAO {

	@Override
	public void insert(NhanVien nv) {
		try (Connection con = ConnectDB.getConnection();) {
			String sql = "insert into nhanvien values('" + nv.getMaNhanVien() + "','" + nv.getTenNhanVien() + "','"
					+ nv.getDiaChiNhanVien() + "','" + nv.getSoDienThoai() + "','" + nv.getPhongBan() + "','"
					+ nv.getNgaySinh() + "')";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(NhanVien nv) {
		try (Connection con = ConnectDB.getConnection();) {
			String sql = "update nhanvien set tenNhanVien='"+nv.getTenNhanVien()+"', diaChiNhanVien='"
					+ nv.getDiaChiNhanVien() + "',soDienThoai='" + nv.getSoDienThoai() + "', phongBan='"
					+ nv.getPhongBan() + "', ngaySinh='" + nv.getNgaySinh() + "' where maNhanVien='" + nv.getMaNhanVien()
					+ "'";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(String maNhanVien) {
		try (Connection con = ConnectDB.getConnection();) {
			String sql = "delete from nhanvien where maNhanVien='" + maNhanVien + "'";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<NhanVien> getAll() {
		ArrayList<NhanVien> nhanVienList = new ArrayList<NhanVien>();
		try (Connection con = ConnectDB.getConnection()) {
			String sql = "select * from nhanvien";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				nhanVienList.add(createNhanvien(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nhanVienList;
	}

	private NhanVien createNhanvien(ResultSet rs) {
		NhanVien nv = null;
		try {
			nv = new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien"), rs.getString("diaChiNhanVien"),
					rs.getString("soDienThoai"), rs.getString("phongBan"), rs.getString("ngaySinh"));
		} catch (Exception e) {
			System.out.println("Lỗi định mệnh");
		}
		return nv;
	}

	@Override
	public NhanVien getByID(String maNhanVien) {
		NhanVien nv = new NhanVien();
		try (Connection con = ConnectDB.getConnection()) {
			String sql = "select * from nhanvien where maNhanVien='"+maNhanVien+"'";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				nv = createNhanvien(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nv;
	}

	@Override
	public int soLuongNhanVien(String tenphongBan) {
		ArrayList<NhanVien> nhanVienList = new ArrayList<NhanVien>();
		try (Connection con = ConnectDB.getConnection()) {
			String sql = "select * from nhanvien where phongBan='"+tenphongBan+"'";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				nhanVienList.add(createNhanvien(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nhanVienList.size();
	}

	@Override
	public ArrayList<NhanVien> getByPhongBan(String tenPhongBan) {
		ArrayList<NhanVien> nhanVienList = new ArrayList<NhanVien>();
		try (Connection con = ConnectDB.getConnection()) {
			String sql = "select * from nhanvien where phongBan='"+tenPhongBan+"'";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				nhanVienList.add(createNhanvien(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nhanVienList;
		
	}

	@Override
	public ArrayList<NhanVien> getByTenNhanVien(String tenNhanVien) {
		ArrayList<NhanVien> nhanVienList = new ArrayList<NhanVien>();
		try (Connection con = ConnectDB.getConnection()) {
			String sql = "select * from nhanvien where tenNhanVien='"+tenNhanVien+"'";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				nhanVienList.add(createNhanvien(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nhanVienList;
	}

}
