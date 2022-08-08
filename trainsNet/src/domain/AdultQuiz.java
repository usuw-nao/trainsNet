package domain;

public class AdultQuiz {
	private Integer id;
	private Integer typeId;
	private String content;
	private String choice1;
	private String choice2;
	private String answer;

	public AdultQuiz() {

	}

	public AdultQuiz(Integer id, Integer typeId, String content, String choice1, String choice2, String answer) {
		this.id = id;
		this.typeId = typeId;
		this.content = content;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.answer = answer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getChoice1() {
		return choice1;
	}

	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}

	public String getChoice2() {
		return choice2;
	}

	public void setChoice2(String choice2) {
		this.choice2 = choice2;

	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;

	}
}