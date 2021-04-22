package blackJack.model;

public class PlayerVO {

	private String playerCard;
	private Integer playerScore;
	
	public String getPlayerCard() {
		return playerCard;
	}
	public void setPlayerCard(String shapes, String strNum) {
		this.playerCard = shapes + strNum;
	}
	public Integer getPlayerScore() {
		return playerScore;
	}
	public void setPlayerScore(Integer playerScore) {
		this.playerScore = playerScore;
	}
	
	
}
