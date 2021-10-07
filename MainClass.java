package Brick;

import javax.swing.*;



public class MainClass extends JFrame {

	public static void main(String[] args) {
		
		MainClass g=new MainClass();
		GamePlay obj=new GamePlay();
		g.setSize(900,660);
		g.setResizable(false);
		g.setTitle("GAME");
		g.setVisible(true);
		g.setDefaultCloseOperation(MainClass.EXIT_ON_CLOSE);
		g.add(obj);

	}

}
 