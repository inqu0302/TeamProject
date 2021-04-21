package blackJack.service;

import blackJack.model.User;

public interface GameInterface {

	public void run();

	public void selectMenu();

	public void cardDraw(User name, int count);

	public void goStay();

	public Integer rule();

	public void printResult();
}
