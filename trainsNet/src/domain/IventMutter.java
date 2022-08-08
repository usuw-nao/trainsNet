package domain;

public class IventMutter {
	private int id;// id
	private String name;
	private String text;// 呟いた時の内容
	private String iventName;

	public IventMutter() {
	}

	public IventMutter(int id, String text) {
		this.id = id;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getText() {
		return text;
	}

	public String getIventName() {
		return iventName;
	}

}
