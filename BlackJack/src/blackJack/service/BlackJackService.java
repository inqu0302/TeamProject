package blackJack.service;

import blackJack.model.BlackJackVO;

public interface BlackJackService {

	public void mainMenu(); 
	public void startGame();
	public void makeCard();
	public String takeCard();
	public void addCard();
	public void checkScore();
}
