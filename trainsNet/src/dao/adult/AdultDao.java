package dao.adult;

import domain.Adult;

public interface AdultDao {
	// ログイン認証用adult１件分
	Adult findByLoginAndPass(String login, String pass) throws Exception;

	// IDを使ってひとりぶんを取り出す？？
	public Adult findById(Integer id) throws Exception;

	// 更新（住所、メールアドレス、ニックネーム、パス）
		void update(Integer id, String login, String nickName, String email, String address) throws Exception;


	// 削除
	void delete(int id, String login) throws Exception;

	// 新規登録,追加
	void insert(Adult adult) throws Exception;

}