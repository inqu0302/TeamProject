package blackJack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import blackJack.model.BlackJackVO;

public class BlackJackServiceV1 implements BlackJackService {

	protected List<BlackJackVO> card;
	protected Scanner scan;
	protected Integer score;
	protected String takeCard;
	
	
	public BlackJackServiceV1() {
		card = new ArrayList<BlackJackVO>();
		scan = new Scanner(System.in);
		score = null;
		takeCard = null;
		// 생성과 동시에 카드 생성
		this.makeCard();
	}
	
	@Override
	public void mainMenu() {
		// TODO 게임 메인 메뉴
		
		while(true) {
			System.out.println("=".repeat(50));
			System.out.println("\t블랙잭 게임");
			System.out.println("=".repeat(50));
			System.out.println("시작하시려면 ENTER 키를 눌러주세요");
			System.out.println("게임종료 : QUIT");
			String menu = scan.nextLine();
			if(menu.equals("QUIT")) {
				return;
			}
			this.startGame();
		}
		
		
		
	}
	
	@Override
	public void startGame() {
		//TODO 게임 시작 및 카드 2장 분배
		// 카드 분배
		takeCard = this.takeCard();
		card.get(0).setDealerCard(takeCard);
		card.get(0).setDealerScore(score);

		takeCard = this.takeCard();
		card.get(0).setGamerCard(takeCard);
		card.get(0).setGamerScore(score);
		
		takeCard = this.takeCard();
		card.get(1).setDealerCard(takeCard);
		card.get(1).setDealerScore(score);
		
		takeCard = this.takeCard();
		card.get(1).setGamerCard(takeCard);
		card.get(1).setGamerScore(score);
		// 딜러와 게이머 각각 2장씩 받음
		System.out.println("게임을 시작합니다.");
		System.out.println("카드를 2장 받았습니다.");
		System.out.println("당신의 카드는");
		System.out.print(card.get(0).getGamerCard() + "\t");
		System.out.println(card.get(1).getGamerCard() + "입니다.");
		this.addCard();
		
//		System.out.println(this.takeCard());
//		System.out.println(takeCard);
//	
//		System.out.println(card.get(0).getdCard());
//		System.out.println(card.get(0).getgCard());
		
	}

	
	
	@Override
	public void addCard() {
		// TODO 카드 추가 메서드
		while(true) {
			System.out.println("카드를 추가하시겠습니까??");
			System.out.print("(Y / N)");
			String yesORno = scan.nextLine();
			if(yesORno.equals("Y")) {
				takeCard = this.takeCard();
				card.get(1).setGamerCard(takeCard);
				card.get(1).setGamerScore(score);
			}
			
		}
		
		
	}

	@Override
	public void makeCard() {
		// TODO 카드를 만드는 메서드

		String[] shapes = new String[] { "Dia◇", "Heart♡", "Spade♤", "Club♧" };
		String[] strNum = new String[] { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "K", "Q" };

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
				VO.setTotalCard(shapes[i], strNum[j]);
				VO.setIntCard(strNum[j]);
				card.add(VO);
			}
		}
		
		
		
		for(int i = 0 ; i < card.size(); i++) {
			
			System.out.println(card.get(i).getTotalCard());
		}
		System.out.println();
		
		
		
	}

	@Override
	public String takeCard() {
		// TODO 카드를 나눠주는 메서드
		Random rnd = new Random();
		
		int rndNum = rnd.nextInt(card.size());
		
//		String cardVO = new BlackJackVO();
		
		String takeCard = card.get(rndNum).getTotalCard();
		score = card.get(rndNum).getIntCard();
		card.remove(rndNum);
		
		return takeCard;
	}



}
