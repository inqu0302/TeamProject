package blackJack.service.impl;

import blackJack.model.Dealer;
import blackJack.model.Player;
import blackJack.model.User;
import blackJack.service.GameInterface;

public class BlackJackServiceV1 implements GameInterface{
	
	protected Dealer dealer;
	protected Player player;
	
	private final Integer 무승부 = null;
	private final Integer 승리 = 10;
	private final Integer 패배 = 20;
	
	public BlackJackServiceV1() {
		dealer = new Dealer();
		player = new Player();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cardDraw(User name, int count) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goStay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer rule() {
		// TODO 점수 계산 
		int playerScore = 0; // 플레이어 총점
		int dealerScore = 0; // 딜러 총점
		
//		playerScore = player.getScore();
//		
//		dealerScore = dealer.getScore();
//		
		if(dealerScore < 17) {
			this.cardDraw(dealer, 1);
			dealerScore = dealer.getScore();
		}
		
//		if()
		
		return null;
		
		
		
	}

	@Override
	public void printResult() {
		// TODO Auto-generated method stub
		
	}
	
	

}
