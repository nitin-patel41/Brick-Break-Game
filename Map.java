package Brick;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Map {
	
	int [][]m;
	int bheight;
	int bwidth;
	Map(int r,int c)
	{
		m=new int[r][c];
		for(int i=0;i<m.length;i++)
		{
			for(int j=0;j<m[i].length;j++)
			{
				m[i][j]=1;
			}
			
		}
		bheight=550/c;
		bwidth=310/r;
	}
	public void draw(Graphics2D g)
	{
		for(int i=0;i<m.length;i++)
		{
			for(int j=0;j<m[i].length;j++)
			{
				if(m[i][j]>0)
				{
					g.setColor(Color.white);
					g.fillRect(j*bwidth+80, i*bheight+100, bwidth, bheight);
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.black);
					g.drawRect(j*bwidth+80, i*bheight+100, bwidth, bheight);
				}
			}
			
		}
	}
	public void binter(int val,int r,int c)
	{
		m[r][c]=0;
	}
	
	
	
	

}
