package Model.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Bean.NhanVien;
import Model.Bean.PhongBan;
import Model.DAO.ConnectDB;
import Model.DAO.PhongBanDAO;

public class PhongBanBO implements PhongBanDAO {

	@Override
	public void insert(PhongBan pb) {
		try(Connection con = ConnectDB.getConnection()){
			String sql ="insert into phongban values('"+pb.getMaPhongBan()+"','"+pb.getTenPhongBan()+"')";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();	
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void update(PhongBan pb) {
		try(Connection con = ConnectDB.getConnection()){
			String sql ="update phongban set tenPhongBan='"+pb.getTenPhongBan()+"' where maPhongBan='"+pb.getMaPhongBan()+"'";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();	
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(String maPhongBan) {
		try(Connection con = ConnectDB.getConnection()){
			String sql ="delete from phongban where maPhongBan='"+maPhongBan+"'";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();	
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<PhongBan> getAll() {
		ArrayList<PhongBan> PhongBanList = new ArrayList<PhongBan>();
		try (Connection con = ConnectDB.getConnection()) {
			String sql = "select * from phongban";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PhongBanList.add(createPhongBan(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return PhongBanList;
	}

	private PhongBan createPhongBan(ResultSet rs) throws SQLException {
		PhongBan phongBan = new PhongBan(rs.getString("maPhongBan"), rs.getString("tenPhongBan"));
		return phongBan;
	}

	@Override
	public PhongBan getByID(String maPhongBan) {
		PhongBan phongban = new PhongBan();
		try (Connection con = ConnectDB.getConnection()) {
			String sql = "select * from phongban where maPhongBan='"+maPhongBan+"'";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				phongban=createPhongBan(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return phongban;
	}

	@Override
	public ArrayList<PhongBan> getByTenPhongBan(String tenPhongBan) {
		ArrayList<PhongBan> PhongBanList = new ArrayList<PhongBan>();
		try (Connection con = ConnectDB.getConnection()) {
			String sql = "select * from phongban where tenPhongBan='"+tenPhongBan+"'";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PhongBanList.add(createPhongBan(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return PhongBanList;
	}

}
