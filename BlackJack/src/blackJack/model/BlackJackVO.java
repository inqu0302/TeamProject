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
	public void setgCard(String gCard) {
		this.gCard = gCard;
	}
	public String getdCard() {
		return dCard;
	}
	public void setdCard(String dCard) {
		this.dCard = dCard;
	}
	
}
