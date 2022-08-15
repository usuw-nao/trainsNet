package domain;

public class IventMutter {
	private int id;// id
	private String name;
	private String text;// 呟いた時の内容
	private String iventName;
	//private Date date;

	public IventMutter() {
	}

	public IventMutter(int id, String text) {
		this.id = id;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIventName() {
		return iventName;
	}

	public void setIventName(String iventName) {
		this.iventName = iventName;
	}

	/*public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}*/

}
