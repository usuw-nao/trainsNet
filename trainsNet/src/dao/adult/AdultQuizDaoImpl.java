package dao.adult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.AdultQuiz;

public class AdultQuizDaoImpl implements AdultQuizDao {
	private DataSource ds;

	public AdultQuizDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public AdultQuiz findById(Integer id) throws Exception {
		AdultQuiz adultQuiz = null;
		try (Connection con = ds.getConnection()) {
			//String sql = "select * adult_quiz where id=?";
			String sql = "select * from adult_quiz order by rand() limit 1";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				adultQuiz = mapToAdultQuiz(rs);
				System.out.println(id);
			}
		} catch (Exception e) {
			throw e;
		}
		return adultQuiz;
	}

	@Override
	public List<AdultQuiz> findAll() throws Exception {
		List<AdultQuiz> AQList = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			String sql = "select * from adult_quiz order by rand() limit 1";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				AQList.add(mapToAdultQuiz(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return AQList;

	}

	private AdultQuiz mapToAdultQuiz(ResultSet rs) throws Exception {
		Integer id = (Integer) rs.getObject("id");
		Integer typeId = (Integer) rs.getObject("type_id");
		String content = rs.getString("content");
		String choice1 = rs.getString("choice1");
		String choice2 = rs.getString("choice2");

		return new AdultQuiz(id, typeId, content, choice1, choice2);

	}

}
