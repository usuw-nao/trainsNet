package dao.adult;

import java.util.List;

import domain.AdultQuiz;

public interface AdultQuizDao {
	// IDを使って一つを取り出す
	public AdultQuiz findById(Integer id) throws Exception;

	List<AdultQuiz> findAll() throws Exception;
}
