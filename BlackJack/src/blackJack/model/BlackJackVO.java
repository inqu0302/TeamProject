package blackJack.model;

public class BlackJackVO {
	
	private String totalCard;
	private String gamerCard;
	private String dealerCard;
	private Integer intCard;
	private Integer gamerScore;
	private Integer dealerScore;
	
	
	public String getTotalCard() {
		return totalCard;
	}
	public void setTotalCard(String shapes, String numbers) {
		this.totalCard = shapes + numbers;
	}
	public String getGamerCard() {
		return gamerCard;
	}
	public void setGamerCard(String takeCard) {
		this.gamerCard = takeCard;
	}
	public String getDealerCard() {
		return dealerCard;
	}
	public void setDealerCard(String takeCard) {
		this.dealerCard = takeCard;
	}
	public Integer getIntCard() {
		return intCard;
	}
	public void setIntCard(String intCard) {
		if(intCard.equals("A")) intCard = "1";
		else if(intCard.equals("Q") || intCard.equals("J") 
				|| intCard.equals("K")) intCard = "10";
		Integer num = Integer.valueOf(intCard);
		this.intCard = num;
	}
	public Integer getGamerScore() {
		return gamerScore;
	}
	public void setGamerScore(Integer gamerScore) {
		this.gamerScore = gamerScore;
	}
	public Integer getDealerScore() {
		return dealerScore;
	}
	public void setDealerScore(Integer dealerScore) {
		this.dealerScore = dealerScore;
	}
	
	
	
}
