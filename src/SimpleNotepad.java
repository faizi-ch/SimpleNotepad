import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SimpleNotepad extends JFrame implements ActionListener
{
	JTextArea textArea;
	JMenuBar menuBar;
	JMenu fileMenu, editMenu, formatMenu, aboutMenu;
	JMenuItem newFile,openFile,saveFile, exit;
	JMenuItem clearAll;
	JMenu fontMenu, fontColorMenu, fontStyle, fontSize;
	JMenuItem aboutDeveloper, aboutSoftware;
	JRadioButtonMenuItem anonymous, ariel, comicSans, courier, serif, timesNewRoman;
	ButtonGroup fontButtonsGroup;
	JRadioButtonMenuItem[] colorRadioButtons;
	ButtonGroup colorButtonsGroup;
	private static final String[] colorsNames = { "Black", "Blue", "Cyan",
			"Dark Grey", "Grey", "Light Grey", "Green", "Red", "Orange",
			"Yellow", "Magenta", "Pink" };
	private static final Color[] colors = { Color.BLACK, Color.BLUE, Color.CYAN,
			Color.DARK_GRAY, Color.GRAY, Color.LIGHT_GRAY, Color.GREEN,
			Color.RED, Color.ORANGE, Color.YELLOW, Color.MAGENTA, Color.PINK };

	SimpleNotepad()
	{
		super("Simple Notepad");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocation(330,180);
		setSize(650,400);

		textArea=new JTextArea();
		add(textArea,BorderLayout.CENTER);

		fileMenu=new JMenu("File");
		editMenu=new JMenu("Edit");
		formatMenu=new JMenu("Format");
		aboutMenu=new JMenu("About");

		menuBar=new JMenuBar();
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(formatMenu);
		menuBar.add(aboutMenu);
		add(menuBar, BorderLayout.NORTH);

		newFile=new JMenuItem("New     Ctrl+N");
		openFile=new JMenuItem("Open     Ctrl+O");
		saveFile=new JMenuItem("Save    Ctrl+S");
		exit=new JMenuItem("Exit     Alt+F4");

		saveFile.addActionListener(this);
		exit.addActionListener(this);

		fileMenu.add(newFile);
		fileMenu.add(openFile);
		fileMenu.add(saveFile);
		fileMenu.addSeparator();
		fileMenu.add(exit);

		clearAll=new JMenuItem("Clear All");

		editMenu.add(clearAll);

		fontMenu=new JMenu("Font");
		formatMenu.add(fontMenu);

		anonymous=new JRadioButtonMenuItem("Anonymous Pro",true);
		ariel=new JRadioButtonMenuItem("Ariel",false);
		comicSans=new JRadioButtonMenuItem("Comic Sans MS",false);
		courier=new JRadioButtonMenuItem("Courier",false);
		serif=new JRadioButtonMenuItem("Serif",false);
		timesNewRoman=new JRadioButtonMenuItem("Time New Roman",false);

		fontButtonsGroup=new ButtonGroup();
		fontButtonsGroup.add(anonymous);
		fontButtonsGroup.add(ariel);
		fontButtonsGroup.add(comicSans);
		fontButtonsGroup.add(courier);
		fontButtonsGroup.add(serif);
		fontButtonsGroup.add(timesNewRoman);

		fontMenu.add(anonymous);
		fontMenu.add(ariel);
		fontMenu.add(comicSans);
		fontMenu.add(courier);
		fontMenu.add(serif);
		fontMenu.add(timesNewRoman);

		anonymous.addActionListener(this);
		ariel.addActionListener(this);
		comicSans.addActionListener(this);
		courier.addActionListener(this);
		serif.addActionListener(this);
		timesNewRoman.addActionListener(this);

		fontStyle=new JMenu("Font Style");
		formatMenu.add(fontStyle);





		setVisible(true);
	}

	@Override public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==openFile)
		{
			FileReader fr = null;
			try
			{
				fr = new FileReader("C:\\Users\\Faizi\\Desktop\\test.txt");
			}
			catch (FileNotFoundException e1)
			{
				e1.printStackTrace();
			}
			BufferedReader br = new BufferedReader(fr);
			String s;
			try
			{
				while ((s = br.readLine()) != null)
				{
					textArea.setText(s);
				}
			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}

		else if(e.getSource()==saveFile)
		{
			String text=textArea.getText();
			try
			{
				//OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("C:\\Users\\Faizi\\Desktop\\test.txt"), "UTF-8");
				FileWriter f1 = new FileWriter("C:\\Users\\Faizi\\Desktop\\test.txt");
				f1.write(text);
				f1.close();
			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==exit)
			System.exit(0);
		else if(anonymous.isSelected())
			textArea.setFont(new Font("Anonymous Pro",Font.PLAIN,14));
		else if(ariel.isSelected())
			textArea.setFont(new Font("Ariel",Font.PLAIN,14));
		else if(comicSans.isSelected())
		{
			textArea.setFont(new Font("Comic Sans MS",Font.PLAIN,14));
			textArea.setSelectedTextColor(Color.GREEN);
		}

		else if(courier.isSelected())
			textArea.setFont(new Font("Courier",Font.PLAIN,14));
		else if(serif.isSelected())
			textArea.setFont(new Font("Serif",Font.PLAIN,14));
		else if(timesNewRoman.isSelected())
			textArea.setFont(new Font("Times New Roman",Font.PLAIN,14));


	}

	public static void main(String[] args)
	{
		SimpleNotepad notepad=new SimpleNotepad();
	}
}
