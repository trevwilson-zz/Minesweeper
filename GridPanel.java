import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GridPanel extends JPanel
{
	private String state;
	private ImageIcon icon, blankIcon,  flaggedIcon, mineIcon, hiddenIcon, questionIcon, oneIcon, twoIcon, threeIcon, fourIcon, fiveIcon, sixIcon, sevenIcon, eightIcon;
	private int x = 0, y = 0;	
	private boolean hasMine;	
	private int indexOne, indexTwo;
	private boolean tried;
	
	public GridPanel(int index1, int index2)
	{
		hasMine = false;
		state = "hidden";
		icon = new ImageIcon("tile.png");
		flaggedIcon = new ImageIcon("flag.gif");
		mineIcon = new ImageIcon("mine32.gif");
		questionIcon = new ImageIcon("question.jpg");
		hiddenIcon = new ImageIcon("tile.png");
		oneIcon = new ImageIcon("1.png");
		twoIcon = new ImageIcon("2.png");
		threeIcon = new ImageIcon("3.png");
		fourIcon = new ImageIcon("4.png");
		fiveIcon = new ImageIcon("5.png");
		sixIcon = new ImageIcon("6.png");
		sevenIcon = new ImageIcon("7.png");
		eightIcon = new ImageIcon("8.png");
		blankIcon = new ImageIcon("blank.jpg");
		indexOne = index1;
		indexTwo = index2;
		tried = false;
	}
		
	public void SetState(String newState)
	{
		state = newState;
	}
	
	public String GetState()
	{
		return state;
	}
	
	public void paintComponent (Graphics g)
	{
		icon.paintIcon(this, g, x, y);
	}

	public void setIcon (ImageIcon newIcon)
	{
		icon = newIcon;
		repaint();
	}
	public void check ()
	{
		if(hasMine())
		{
			setIcon(mineIcon);
			SetState("mine");
			repaint();
		}
	}
	public int checkFlag(int flagsLeft)
	{
		int newFlag = 2;
		if(state.equals("hidden") && flagsLeft > 0)
		{
			setIcon(flaggedIcon);
			newFlag = 0;
			SetState("flag");
		}
		else if(state.equals("flag"))
		{
			setIcon(questionIcon);
			newFlag = 1;
			SetState("question");
		}
		else if(state.equals("question"))
		{
			setIcon(hiddenIcon);
			SetState("hidden");
		}
		return newFlag;
	}
	public boolean hasMine()
	{
		return hasMine;
	}
	public void setMine(boolean nowHasMine)
	{
		hasMine = nowHasMine;
	}
	public int getIndexOne()
	{
		return indexOne;
	}
	public int getIndexTwo()
	{
		return indexTwo;
	}
	public void setNumber(int num)
	{
		if(num == 1)
		{
			setIcon(oneIcon);
		}
		if(num == 2)
			setIcon(twoIcon);
		if(num == 3)
			setIcon(threeIcon);
		if(num == 4)
			setIcon(fourIcon);
		if(num == 5)
			setIcon(fiveIcon);
		if(num == 6)
			setIcon(sixIcon);
		if(num == 7)
			setIcon(sevenIcon);
		if(num == 8)
			setIcon(eightIcon);
		SetState("numbered");
	}
	public boolean hasTried()
	{
		return tried;
	}
	public void setTried(boolean getTried)
	{
		tried = getTried;
	}
	public void setBlank()
	{
		SetState("blank");
		setIcon(blankIcon);
	}
}
