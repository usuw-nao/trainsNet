package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Ivent;

public class IventDaoImpl implements IventDao {
	private DataSource ds;

	public IventDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Ivent> findAll() throws Exception {
		List<Ivent> iventList = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "select * from ivent";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				iventList.add(mapToIvent(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return iventList;
	}

	@Override
	public Ivent findById(Integer id) throws Exception {
		Ivent ivent = new Ivent();
		try (Connection con = ds.getConnection()) {
			String sql = "select*from ivent where id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				ivent = mapToIvent(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return ivent;
	}

	private Ivent mapToIvent(ResultSet rs) throws Exception {
		Ivent ivent = new Ivent();
		ivent.setId(rs.getInt("id"));
		ivent.setName(rs.getString("name"));
		ivent.setDetail(rs.getString("detail"));
		ivent.setDay(rs.getDate("day"));
		return ivent;

	}

}
