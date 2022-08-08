package dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DaoFactory {
	public static dao.adult.AdultDao createAdultDao() {
		return new dao.adult.AdultDaoImpl(getDataSource());
	}

	public static dao.IventDao createIventDao() {
		return new dao.IventDaoImpl(getDataSource());
	}

	public static dao.adult.AdultQuizDao createAdultQuizDao() {
		return new dao.adult.AdultQuizDaoImpl(getDataSource());
	}

	public static dao.IventMutterDao createIventMutterDao() {
		return new dao.IventMutterDaoImpl(getDataSource());
	}

	private static DataSource getDataSource() {
		InitialContext ctx = null;
		DataSource ds = null;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mytrains_db");
		} catch (NamingException e) {
			if (ctx != null) {
				try {
					ctx.close();
				} catch (NamingException e1) {
					throw new RuntimeException(e1);
				}
			}
			throw new RuntimeException(e);
		}

		return ds;
	}

}