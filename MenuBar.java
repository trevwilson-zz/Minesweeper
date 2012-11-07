import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MenuBar extends JPanel
{
	String currentDiff;
	JMenuBar menuBar;
	MinesweeperGrid Grid;
	JFrame frame;

	public MenuBar()
	{
		frame = new JFrame("Minesweeper");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		Grid = new MinesweeperGrid(frame);
					
		currentDiff = "easyDiff";	
	
		menuBar = new JMenuBar();
                JMenu fileMenu = new JMenu("File");
                JMenuItem quitMenu = new JMenuItem("Quit");
                JMenu diffMenu = new JMenu("Difficulty");
                JMenuItem easyMenu = new JMenuItem("Easy");
                JMenuItem mediumMenu = new JMenuItem("Medium");
                JMenuItem hardMenu = new JMenuItem("Hard");
                JMenu helpMenu = new JMenu("Help");
                JMenuItem aboutMenu = new JMenuItem("About");

                quitMenu.addActionListener(new quitListener());
                aboutMenu.addActionListener(new aboutListener());
		
		
		easyMenu.addActionListener(new easyListener());
		mediumMenu.addActionListener(new mediumListener());
		hardMenu.addActionListener(new hardListener());

                fileMenu.add(quitMenu);
                diffMenu.add(easyMenu);
                diffMenu.add(mediumMenu);
                diffMenu.add(hardMenu);
                helpMenu.add(aboutMenu);
                menuBar.add(fileMenu);
                menuBar.add(diffMenu);
                menuBar.add(helpMenu);

		frame.setJMenuBar(menuBar);
		frame.setSize(500,500);
		frame.setVisible(true);
	}

	public JMenuBar getMenuBar()
	{
		return menuBar;
	}

	public class quitListener implements ActionListener
        {
                public void actionPerformed (ActionEvent event)
                {
                        System.exit(0);
                }
        }

        public class aboutListener implements ActionListener
        {
                public void actionPerformed (ActionEvent event)
                {
                        JFrame popUp = new JFrame("About");
                        JLabel aboutText = new JLabel("Wilson/Tan Minesweeper Project 4");
                        popUp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        popUp.add(aboutText);
                        popUp.pack();
                        popUp.setVisible(true);
                }
        }
	
	public class easyListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			Grid.changeDiff("easy");
			frame.setSize(500,500);
			currentDiff = "easyDiff";
		}
	}

	public class mediumListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			Grid.changeDiff("medium");
			frame.setSize(800,800);
			currentDiff = "mediumDiff";
		}
	}		
	public class hardListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			Grid.changeDiff("hard");
			frame.setSize(1200,1200);
			currentDiff = "hardDiff";
		}

	}				

}

