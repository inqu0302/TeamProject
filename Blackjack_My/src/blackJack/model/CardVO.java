package blackJack.model;

public class CardVO {

	private String shapes;
	private String strNum;
	private Integer score;
	
	public String getShapes() {
		return shapes;
	}
	public void setShapes(String shapes) {
		this.shapes = shapes;
	}
	public String getStrNum() {
		return strNum;
	}
	public void setStrNum(String strNum) {
		this.strNum = strNum;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(String strNum) {
		try {
			this.score = Integer.valueOf(strNum);
		} catch (NumberFormatException e) {
			if (strNum == "A") {
				this.score = 1;
			} else {
				this.score = 10;
			}
		}
	}
	
	
}
