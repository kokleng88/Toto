import javax.swing.*;
import java.awt.event.*;

class Toto extends JFrame implements ActionListener
{
	// Components
	ClassLoader ldr = this.getClass().getClassLoader();
	java.net.URL iconURL = ldr.getResource("Lotto.png");
	ImageIcon icon = new ImageIcon(iconURL);
	JLabel img = new JLabel(icon);
	JTextField txt = new JTextField("",18);
	JButton btn = new JButton("Get My Lucky Numbers");
	JPanel pnl = new JPanel();
	
	// Constructor
	public Toto()
	{
		super("Toto App");	
		setSize(260,210);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pnl.add(img);pnl.add(txt);pnl.add(btn);
		btn.addActionListener(this);
		add(pnl);setVisible(true);
	}
	
	// Event-handler	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource()==btn)
		{
			int[] nums = new int[50]; String str = "";
			for (int i=1;i<50;i++)
			{
				nums[i]=i;
			}
			for (int i=1;i<50;i++)
			{
				int r = (int)(49*Math.random())+1;
				int t = nums[i];nums[i]=nums[r];nums[r]=t;
			}
			for (int i=1;i<7;i++)
			{
				str += " " + Integer.toString(nums[i]) + " "; 
			}
			str += 	"(" + Integer.toString(nums[7]) + ")";		
			txt.setText(str);
		}
	}	
	
	// Entry-point
	public static void main (String[] args)
	{
		Toto toto = new Toto();
	}
}