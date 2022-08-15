package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.IventMutter;

public class IventMutterDaoImpl implements IventMutterDao {
	private DataSource ds;

	public IventMutterDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<IventMutter> findAll() throws Exception {
		List<IventMutter> iventMutterList = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			String sql = "select * from ivent_mutter order by id DESC";
			PreparedStatement pStmt = con.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				iventMutterList.add(mapToIventMutter(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return iventMutterList;
	}

	private IventMutter mapToIventMutter(ResultSet rs) throws Exception {
		IventMutter iventMutter = new IventMutter();
		iventMutter.setId(rs.getInt("id"));
		iventMutter.setName(rs.getString("name"));
		iventMutter.setText(rs.getString("text"));
		iventMutter.setIventName(rs.getString("iventName"));
		return iventMutter;

	}

	@Override
	public void insert(IventMutter iventMutter) throws Exception {
		try {
			Connection con = ds.getConnection();
			String sql = "insert into ivent_mutter values(?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, iventMutter.getId(), Types.INTEGER);
			stmt.setString(2, iventMutter.getName());
			stmt.setString(3, iventMutter.getText());
			stmt.setString(4, iventMutter.getIventName());

			stmt.executeUpdate();

		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void updated(IventMutter iventMutter) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "UPDATE ivent_mutter "
					+ " SET name = ?, text = ?, ivent_name = ? "
					+ " WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, iventMutter.getName());
			stmt.setObject(2, iventMutter.getText());
			stmt.setString(3, iventMutter.getIventName());
			stmt.setObject(5, iventMutter.getId(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void delete(IventMutter iventMutter) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}
}