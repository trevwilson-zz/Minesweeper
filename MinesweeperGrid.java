import java.awt.*;
import javax.swing.*; 
import java.awt.event.*;

public class MinesweeperGrid extends JPanel
{

	int currentTime = 0;
	int flagsLeft = 10;	
	JFrame frame;
	GridPanel[][] grid;
	String currentDiff = "easy";	
	JButton reset = new JButton ("Reset");
	JLabel  time = new JLabel ("0");
	JLabel flag = new JLabel ("10");

	javax.swing.Timer timer = new javax.swing.Timer(1000, new timeListener());
	

	public MinesweeperGrid(JFrame newFrame)
	{
		
		reset.addActionListener(new resetListener());		
		frame = newFrame;
		grid = new GridPanel[9][9];
		frame.getContentPane().setLayout(new GridLayout(10,9,0,0));

		frame.getContentPane().add(time);
		frame.getContentPane().add(new JLabel());
		frame.getContentPane().add(new JLabel());
		frame.getContentPane().add(new JLabel());
		frame.getContentPane().add(reset);
		frame.getContentPane().add(new JLabel());
		frame.getContentPane().add(new JLabel());
		frame.getContentPane().add(new JLabel());
		frame.getContentPane().add(flag);
	
		for( int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				grid[i][j] = new GridPanel(i, j);
				frame.getContentPane().add(grid[i][j]);
				grid[i][j].addMouseListener(new GridListener());
			}
		}
	
		timer.start();
		
		int minesPlaced = 0;	
		while (minesPlaced < 10)
		{
			int RandomI = (int) (Math.random() * 9);
			int RandomJ = (int)(Math.random() * 9);
			if (!grid[RandomI][RandomJ].hasMine())
			{
				grid[RandomI][RandomJ].setMine(true);
				minesPlaced++;
			}
		}	
	}

	public void changeDiff(String newDiff)
	{
		currentTime = 0;
		if (newDiff.equals("easy"))
		{
			flagsLeft = 10;
			flag.setText(Integer.toString(flagsLeft));
			GridPanel[][] newGrid = new GridPanel[9][9];
			frame.getContentPane().removeAll();
					
			frame.getContentPane().setLayout(new GridLayout(10,9,0,0));

			frame.getContentPane().add(time);
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(reset);
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());		
			frame.getContentPane().add(flag);

			for( int i = 0; i < 9; i++)
			{
				for (int j = 0; j < 9; j++)
				{
					newGrid[i][j] = new GridPanel(i, j);
					frame.getContentPane().add(newGrid[i][j]);
					newGrid[i][j].addMouseListener(new GridListener());
				}
			}
			currentDiff = "easy";
			
			int minesPlaced = 0;	
			while (minesPlaced < 10)
			{
				int RandomI = (int) (Math.random() * 9);
				int RandomJ = (int)(Math.random() * 9);
				if (!newGrid[RandomI][RandomJ].hasMine())
				{
					newGrid[RandomI][RandomJ].setMine(true);
					minesPlaced++;
				}
			}
			frame.getContentPane().validate();
			super.repaint();
		}
	
		if (newDiff.equals("medium"))
		{
			flagsLeft = 40;
			flag.setText(Integer.toString(flagsLeft));
			GridPanel[][] newGrid = new GridPanel[16][16];
			frame.getContentPane().removeAll();
					
			frame.getContentPane().setLayout(new GridLayout(17,16,0,0));

			frame.getContentPane().add(time);
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(reset);
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(flag);

			for( int i = 0; i < 16; i++)
			{
				for (int j = 0; j < 16; j++)
				{
					newGrid[i][j] = new GridPanel(i, j);
					frame.getContentPane().add(newGrid[i][j]);
					newGrid[i][j].addMouseListener(new GridListener());
				}
			}
			currentDiff = "medium";
			
			int minesPlaced = 0;	
			while (minesPlaced < 40)
			{
				int RandomI = (int) (Math.random() * 16);
				int RandomJ = (int)(Math.random() * 16);
				if (!newGrid[RandomI][RandomJ].hasMine())
				{
					newGrid[RandomI][RandomJ].setMine(true);
					minesPlaced++;
				}
			}
			
			super.repaint();
			frame.getContentPane().validate();
		}
		
		if (newDiff.equals("hard"))
		{
			flagsLeft = 99;
			flag.setText(Integer.toString(flagsLeft));
			GridPanel[][] newGrid = new GridPanel[24][20];
			frame.getContentPane().removeAll();
					
			frame.getContentPane().setLayout(new GridLayout(25,20,0,0));

			frame.getContentPane().add(time);
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(reset);
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(new JLabel());
			frame.getContentPane().add(flag);

			for( int i = 0; i < 24; i++)
			{
				for (int j = 0; j <20; j++)
				{
					newGrid[i][j]= new GridPanel(i, j);
					frame.getContentPane().add(newGrid[i][j]);
					newGrid[i][j].addMouseListener(new GridListener());
				}
			}
			currentDiff = "hard";
			
			int minesPlaced = 0;	
			while (minesPlaced < 99)
			{
				int RandomI = (int) (Math.random() * 24);
				int RandomJ = (int)(Math.random() * 20);
				if (!newGrid[RandomI][RandomJ].hasMine())
				{
					newGrid[RandomI][RandomJ].setMine(true);
					minesPlaced++;
				}
			}
			
			frame.getContentPane().validate();
			super.repaint();
			
		}
	}
		
	public class resetListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			changeDiff(currentDiff);
		}
	}
	public class timeListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			currentTime++;
			time.setText(Integer.toString(currentTime));
			repaint();
		}
	}
	public class GridListener implements MouseListener
	{
		public void mousePressed(MouseEvent e)
		{
			
			GridPanel Source = (GridPanel) e.getSource();
			if(e.isMetaDown())
			{
				int changed = Source.checkFlag(flagsLeft);
				if(changed == 0)
				{
					flagsLeft --;
				}
				else if(changed == 1)
				{
					flagsLeft ++;
				}


				flag.setText(Integer.toString(flagsLeft));		
			}				
			else if(!e.isMetaDown())
			{
				Source.check();
				if(Source.hasMine())
				{
					for(int i = 0; i < grid.length; i++)
					{
						for(int j = 0; j < grid[0].length; j++)
						{
							grid[i][j].check();
						}
					}
					final JFrame popUp = new JFrame("Game Over");
					JLabel GameOver = new JLabel("You clicked on a mine. Game Over. Click OK to play again.");
					popUp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					JButton OKButton = new JButton("OK");
					JPanel panel = new JPanel();
					panel.add(OKButton);
					OKButton.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							changeDiff(currentDiff);
							popUp.setVisible(false);
						}
					});
					popUp.add(GameOver, BorderLayout.NORTH);
					popUp.add(panel, BorderLayout.CENTER);
					popUp.pack();
					popUp.setVisible(true);
				}
				else if(checkBeside(Source)!= 0)
				{
					Source.setNumber(checkBeside(Source));
				}
				else
				{
					recurse(Source.getIndexOne(), Source.getIndexTwo());
				}
			}
			repaint();
			frame.getContentPane().validate();
		}
		public void mouseReleased(MouseEvent e)
		{
		}
		public void mouseEntered(MouseEvent e)
		{
		}
		public void mouseExited(MouseEvent e)
		{
		}
		public void mouseClicked(MouseEvent e)
		{
		}
	}
	public int checkBeside(GridPanel source)
	{
		int currentCount = 0;
		int indexOne = source.getIndexOne();
		int indexTwo = source.getIndexTwo();
		//try
		//{
			if(valid(indexOne + 1, indexTwo) && grid[indexOne + 1][indexTwo].hasMine())
			{
				currentCount++;
			}

			if(valid(indexOne - 1, indexTwo) && grid[indexOne - 1][indexTwo].hasMine())
			{
				currentCount++;
			}

			if(valid(indexOne, indexTwo + 1) && grid[indexOne][indexTwo + 1].hasMine())
			{
				currentCount++;
			}

			if(valid(indexOne, indexTwo - 1) && grid[indexOne][indexTwo - 1].hasMine())
			{
				currentCount++;
			}

			if(valid(indexOne - 1, indexTwo - 1) && grid[indexOne - 1][indexTwo - 1].hasMine())
			{
				currentCount++;
			}
			
			if(valid(indexOne - 1, indexTwo + 1) && grid[indexOne - 1][indexTwo + 1].hasMine())
			{
				currentCount++;
			}

			if(valid(indexOne + 1, indexTwo + 1) && grid[indexOne + 1][indexTwo + 1].hasMine())
			{
				currentCount++;
			}
			
			if(valid(indexOne + 1, indexTwo - 1) && grid[indexOne + 1][indexTwo - 1].hasMine())
			{
				currentCount++;
			}
		//}
		/*catch(IndexOutOfBoundsException e)
		{
		}*/
	return currentCount;
	}
	public int recurse(int row, int column)
	{
		
		if(valid (row, column) && grid[row][column].hasTried() == false)
		{
			if(checkBeside(grid[row][column]) == 0)
			{
				grid[row][column].setTried(true);
				grid[row][column].setBlank();
				recurse(row + 1, column);
				recurse(row - 1, column);
				recurse(row, column + 1);
				recurse(row, column - 1);
				recurse(row + 1, column + 1);
				recurse(row - 1, column - 1);
				recurse(row + 1, column - 1);
				recurse(row - 1, column + 1);
			}
			else
			{
				grid[row][column].setNumber(checkBeside(grid[row][column]));
			}
		}
		return 0;
	}
	public boolean valid(int row, int column)
	{
		boolean result = false;
		if(row >= 0 && row < grid.length && column >= 0 && column < grid[0].length)
		{
			result = true;
		}
		return result;
	}
}


