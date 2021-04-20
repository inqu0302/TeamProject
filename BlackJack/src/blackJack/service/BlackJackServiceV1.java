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
	protected Integer gamerIndex;
	protected Integer dealerIndex;
	protected int gamerScore;
	protected int dealerScore;
	
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
		gamerIndex = 0;
		dealerIndex = 0;
		
		gamerScore = 0;
		dealerScore = 0;
		
		takeCard = this.takeCard();
		card.get(dealerIndex).setDealerCard(takeCard);
		card.get(dealerIndex).setDealerScore(score);
		dealerIndex++;
		
		takeCard = this.takeCard();
		card.get(gamerIndex).setGamerCard(takeCard);
		card.get(gamerIndex).setGamerScore(score);
		gamerIndex++;
		
		takeCard = this.takeCard();
		card.get(dealerIndex).setDealerCard(takeCard);
		card.get(dealerIndex).setDealerScore(score);
		dealerIndex++;
		
		takeCard = this.takeCard();
		card.get(gamerIndex).setGamerCard(takeCard);
		card.get(gamerIndex).setGamerScore(score);
		gamerIndex++;
		
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
			System.out.println("=".repeat(80));
			System.out.println("카드를 추가하시겠습니까??");
			System.out.print("(Y / N)");
			String yesORno = scan.nextLine();
			if(yesORno.equals("Y")) {
				takeCard = this.takeCard();
				card.get(gamerIndex).setGamerCard(takeCard);
				card.get(gamerIndex).setGamerScore(score);
				gamerIndex++;
				
				for(int i = 0 ; i < gamerIndex ; i++) {
					System.out.print(card.get(i).getGamerCard() + "\t");
					gamerScore += card.get(i).getGamerScore(); 
				}
				if( gamerScore >21) {
					System.out.println("카드의 합이 21이 넘어 당신의 패배입니다.");
					return;
				} else if(gamerScore == 21) {
					System.out.println("!!Black Jack!!");
					System.out.println("축하합니다 당신의 승리입니다.");
					return;
				}
				System.out.printf("당신의 카드의 합은 %d 입니다\n", gamerScore);
				continue;
			}else if(yesORno.equals("N")) {
				
				if(gamerScore <= 16) {
					System.out.println("카드의 합이 17 이상이어야 합니다.");
					continue;
				} else {
					this.checkScore();
					return;
				}
			}else {
				System.out.println("다시 입력해 주세요");
				continue;
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

	@Override
	public void checkScore() {
		// TODO 점수를 계산하여 승패를 나누는 메서드
		for(int i = 0 ; i < dealerIndex ; i++) {
			
			dealerScore += card.get(i).getDealerScore();
		}
		
		if(dealerScore <= 16) {
			takeCard = this.takeCard();
			card.get(dealerIndex).setDealerCard(takeCard);
			card.get(dealerIndex).setDealerScore(score);
			dealerScore += card.get(dealerIndex).getDealerScore();
		}
		for(int i = 0 ; i < dealerIndex ; i++) {
			
			System.out.print(card.get(i).getDealerCard() + "\t");
			System.out.println(dealerScore);
		}
		
		int sum = dealerScore - gamerScore;
		
		if(sum < 0 ) {
			System.out.println("플레이어 승리!!");
		} else if(sum == 0) {
			System.out.println("무승부 입니다.");
		} else if(sum > 0) {
			System.out.println("딜러의 승리");
		}
		
	}



}
