package Model.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Bean.NhanVien;

public interface NhanVienDAO {
	public void insert(NhanVien nv);
	public void update(NhanVien nv);
	public void delete(String maNhanVien);
	public ArrayList<NhanVien> getByPhongBan(String tenPhongBan);
	public ArrayList<NhanVien> getAll();
	public NhanVien getByID(String maNhanVien);
	public int soLuongNhanVien(String tenphongBan);
	public ArrayList<NhanVien> getByTenNhanVien(String tenNhanVien);

}
