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

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return iventMutterList;
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
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(IventMutter iventMutter) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}
}