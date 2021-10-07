package Brick;

import javax.swing.JPanel;


import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.*;

public class GamePlay extends JPanel implements KeyListener,ActionListener {

	boolean play=true;
	int score=0;
	int totalb=60;
	Timer time;
	int delay=8;
	int playerX=310;
	int ballX=120;
	int ballY=350;
	int ballXdir=1;
	int ballYdir=2;
	Map gen;
	
	
	
	GamePlay()
	{
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);/*not change component on tab key*/
		time=new Timer(delay,this);
		time.start();
		gen=new Map(5,12);
		
		
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(1, 1, 900, 650);
		
		gen.draw((Graphics2D)g);
		
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 3, 650);
		g.fillRect(0, 0, 900, 3);
		g.fillRect(891, 0, 3,900 );
		
		Color c;
		c=new Color(66, 241, 244);
		g.setColor(c);
		g.fillRect(playerX, 600, 100, 8);
		
		g.setColor(Color.RED);
		g.fillOval(ballX, ballY, 20, 20);
		
		c=new Color(188, 11, 11);
		g.setColor(c);
		g.drawString("nitin patel", 785, 630);
		Font f1=new Font("serif",Font.BOLD,30);
		g.setFont(f1);
		g.setColor(Color.green);
		g.drawString(""+score, 800, 50);
		g.setColor(Color.red);
		Font f=new Font("arial",Font.BOLD,30);
		g.setFont(f);
		if(totalb<=0)
		{
			
			play=false;
			
			g.drawString("You WON", 410, 290);
		
			
			
			g.drawString("Press Enter to restart", 320, 350);
		}
		if(ballY>=600)
		{
			play=false;
			
			g.drawString("Game OVER", 370, 290);
		
			
			
			g.drawString("Press Enter to restart", 320, 350);
		}
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		time.start();
		
		if(play)
		{
			
			ballX-=ballXdir;
			ballY-=ballYdir;
			
			if(new Rectangle(ballX,ballY,20,20).intersects(new Rectangle(playerX,600,100,8)))
			{
				ballYdir=-ballYdir;
			}
			
			
			
			for(int i=0;i<gen.m.length;i++)
			{
				for(int j=0;j<gen.m[i].length;j++)
				{
					if(gen.m[i][j]>0)
					{
						int bx=j*gen.bwidth+80;
						int by=i*gen.bheight+100;
						int bw=gen.bwidth;
						int bh=gen.bheight;
						
						Rectangle rect=new Rectangle(bx,by,bw,bh);
						Rectangle ballrect=new Rectangle(ballX,ballY,20,20);
						Rectangle br=rect;
						if(ballrect.intersects(rect))
						{
							gen.binter(0, i, j);
							totalb--;
							score+=5;
							if(ballX+19<=br.x || ballY+1>=br.x+br.width)
							{
								ballXdir=-ballXdir;
							}
							else
							{
								ballYdir=-ballYdir;
							}
							
							
						}
						
					}
				}
			}
			
			if(ballX<=0)
			{
				ballXdir=-ballXdir;
			}
			if(ballY<0)
			{
				ballYdir=-ballYdir;
			}
			if(ballX>875)
			{
				ballXdir=-ballXdir;
			
			
			}
			
			
			
		}
		
		
		
		
		repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			if(playerX>=790)
			{
				playerX=790;
			}
			else
			{
				moveRight();
			}
		}
		if(arg0.getKeyCode()==KeyEvent.VK_LEFT)
		{
			if(playerX<10)
			{
				playerX=3;
			}
			else
			{
				moveLeft();
			}
		}
		if(arg0.getKeyCode()==KeyEvent.VK_ENTER)
		{
			if(!play)
			{
				
				score=0;
				totalb=60;
				
				delay=8;
				playerX=310;
				ballX=120;
				ballY=350;
				ballXdir=1;
				ballYdir=2;
				gen=new Map(5, 12);
					
			}
		
		}
		
	}
	
	public void moveRight()
	{
		play=true;
		playerX+=20;
	}
	
	public void moveLeft()
	{
		play=true;
		playerX-=20;
	}
	

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
