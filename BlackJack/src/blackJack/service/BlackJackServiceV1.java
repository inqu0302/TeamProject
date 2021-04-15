package blackJack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import blackJack.model.BlackJackVO;

public class BlackJackServiceV1 implements BlackJackService {

	protected List<BlackJackVO> card;

	public BlackJackServiceV1() {
		card = new ArrayList<BlackJackVO>();
		this.makeCard();
	}
	
	@Override
	public void startGame() {
		
		BlackJackVO vo = new BlackJackVO();
		String takeCard = this.takeCard();
		card.get(0).setdCard(takeCard);
		takeCard = this.takeCard();
		card.get(0).setgCard(takeCard);
		
		card.add(vo);
		
		System.out.println(this.takeCard());
		System.out.println(takeCard);
	
		System.out.println(card.get(0).getdCard());
		System.out.println(card.get(0).getgCard());
		
	}

	@Override
	public void makeCard() {
		// TODO 카드를 만드는 메서드

		String[] shapes = new String[] { "Dia◇", "Heart♡", "Spade♤", "Club♧" };
		String[] strNum = new String[] { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "k", "Q" };

//		for (int i = 0; i < 13; i++) {
//			int num = i + 1;
//			String number = null;
//			if (i + 1 == 1)
//				number = "A";
//			else if (i + 1 == 11)
//				number = "K";
//			else if (i + 1 == 12)
//				number = "Q";
//			else if (i + 1 == 13)
//				number = "J";
//
//			number = String.valueOf(num);
//			strNum[i] = number;
//		}

		for (int i = 0; i < shapes.length; i++) {
			for (int j = 0; j < strNum.length; j++) {
				BlackJackVO VO = new BlackJackVO();
				VO.settCard(shapes[i], strNum[j]);
				card.add(VO);
			}
		}
		
		
		
//		String takeCard = card.remove(5);
		for(int i = 0 ; i < card.size(); i++) {
			
			System.out.println(card.get(i).gettCard());
		}
		System.out.println();
		
		
		
	}

	@Override
	public String takeCard() {
		// TODO 카드를 나눠주는 메서드
		Random rnd = new Random();
		
		BlackJackVO randomCard = card.get(rnd.nextInt(card.size()));
		
//		(card.remove(rnd.nextInt(card.size())));		
//		
//		VO.setdCard(null);
		
		int rndNum = rnd.nextInt(card.size());
		
		card.get(rndNum).getdCard();
		
		return card.get(rndNum).gettCard();
	}

	@Override
	public void checkCard() {
		// TODO 카드 유효성검사
	}

}
