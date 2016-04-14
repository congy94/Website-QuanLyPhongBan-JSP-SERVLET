package Model.Bean;

public class NhanVien {
	private String maNhanVien;
	private String tenNhanVien;
	private String diaChiNhanVien;
	private String soDienThoai;
	private String phongBan;
	private String ngaySinh;
	public NhanVien(String maNhanVien, String tenNhanVien, String diaChiNhanVien, String soDienThoai, String phongBan,
			String ngaySinh) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.diaChiNhanVien = diaChiNhanVien;
		this.soDienThoai = soDienThoai;
		this.phongBan = phongBan;
		this.ngaySinh = ngaySinh;
	}
	public NhanVien() {
		// TODO Auto-generated constructor stub
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public String getDiaChiNhanVien() {
		return diaChiNhanVien;
	}
	public void setDiaChiNhanVien(String diaChiNhanVien) {
		this.diaChiNhanVien = diaChiNhanVien;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getPhongBan() {
		return phongBan;
	}
	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	

}
