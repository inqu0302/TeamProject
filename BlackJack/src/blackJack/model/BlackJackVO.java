package blackJack.model;

public class BlackJackVO {
	
	private String tCard;
	private String gCard;
	private String dCard;
	
	
	
	
	public String gettCard() {
		return tCard;
	}
	public void settCard(String shapes, String numbers) {
		this.tCard = shapes + numbers;
	}
	public String getgCard() {
		return gCard;
	}
	public void setgCard(String takeCard) {
		this.gCard = takeCard;
	}
	public String getdCard() {
		return dCard;
	}
	public void setdCard(String takeCard) {
		this.dCard = takeCard;
	}
	
}
