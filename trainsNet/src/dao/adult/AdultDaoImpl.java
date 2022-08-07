package dao.adult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

import javax.sql.DataSource;

import org.mindrot.jbcrypt.BCrypt;

import domain.Adult;

public class AdultDaoImpl implements AdultDao {
	private DataSource ds;

	public AdultDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public Adult findByLoginAndPass(String login, String pass) throws Exception {
		// １件分取り出す
		Adult adult = null;
		try (Connection con = ds.getConnection()) {
			String sql = "select * from adult where login_id=?";
			//String sql = "select a.*, Q.*"
			//		+ " from adult as a inner join adult_Quiz as Q"
			//		+ " on a.type_id = Q.type_id where login_id='?'";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, login);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				if (BCrypt.checkpw(pass, rs.getString("login_pass"))) {
					adult = mapToAdult(rs);
				}
			}

		} catch (Exception e) {
			throw e;
		}

		return adult;
	}

	@Override
	public Adult findById(Integer id) throws Exception {
		Adult adult = new Adult();

		try (Connection con = ds.getConnection()) {
			String sql = "select login_id, nick_name,email,point,address,"
					+ "age, name,ivent,distance,start_date,end_date " + " from adult where id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				adult = mapToAdult(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return adult;

	}

	@Override
	public void update(Integer id, String login, String nickName, String email, String address) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "update adult set login_id=?, nick_name=?, email=?, address=? where id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, login);
			stmt.setString(2, nickName);
			stmt.setString(3, email);
			stmt.setString(4, address);
			stmt.setObject(5, id, Types.INTEGER);

			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void delete(int id, String login) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "delete from adult where id=? and login_id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(2, login);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void insert(Adult adult) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "insert into adult (login_id,login_pass,nick_name,type_id," + " email,name,address,age)"
					+ " values(?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, adult.getLogin());
			stmt.setString(2, BCrypt.hashpw(adult.getPass(), BCrypt.gensalt()));
			stmt.setString(3, adult.getNickName());
			stmt.setObject(4, adult.getTypeId(), Types.INTEGER);
			stmt.setString(5, adult.getEmail());
			stmt.setString(6, adult.getName());
			stmt.setString(7, adult.getAddress());
			stmt.setObject(8, adult.getAge(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	private Adult mapToAdult(ResultSet rs) throws Exception {
		Adult adult = new Adult();
		adult.setId(rs.getInt("id"));
		adult.setLogin(rs.getString("login_id"));
		adult.setPass(rs.getString("login_pass"));
		adult.setNickName(rs.getString("nick_name"));
		adult.setTypeId(rs.getInt("type_id"));
		adult.setEmail(rs.getString("email"));
		adult.setName(rs.getString("name"));
		adult.setAddress(rs.getString("address"));
		adult.setAge(rs.getInt("age"));
		adult.setIvent(rs.getInt("ivent"));
		adult.setDistance(rs.getString("distance"));
		adult.setStartDate(rs.getDate("start_date"));
		adult.setEndDate(rs.getDate("end_date"));

		return adult;
	}

}