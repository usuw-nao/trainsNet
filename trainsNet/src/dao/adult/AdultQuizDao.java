package dao.adult;

import java.util.List;

import domain.AdultQuiz;

public interface AdultQuizDao {
	// IDを使って一つを取り出す
	public AdultQuiz findById(Integer id) throws Exception;

	// ランダムにクイズを取り出す
	List<AdultQuiz> findRandom(int limit) throws Exception;

	public void update(Integer id) throws Exception;

}