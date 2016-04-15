package Model.DAO;

import java.util.ArrayList;

import Model.Bean.PhongBan;

public interface PhongBanDAO {
	public void insert(PhongBan pb);
	public void update(PhongBan pb);
	public void delete(String maPhongBan);
	public ArrayList<PhongBan> getAll();
	public PhongBan getByID(String maPhongBan);
	public ArrayList<PhongBan> getByTenPhongBan(String tenPhongBan);
}
