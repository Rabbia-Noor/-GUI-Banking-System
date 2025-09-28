package bankingdbms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
	
	JButton withdraw,back;
	JTextField amount;
	String pinnumber;
	
	Withdrawl(String pinnumber){
		
		this.pinnumber=pinnumber;
	
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm2.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800, 750, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel label = new JLabel(i1);
		label.setBounds(0,0,800,750);
		add(label);
		
		JLabel text = new JLabel("Enter the amount you want to Withdraw");
		text.setFont(new Font("System",Font.BOLD,16));
		text.setForeground(Color.WHITE);
		text.setBounds(150,150,700,20);
		label.add(text);

	    amount = new JTextField();
		amount.setBounds(150,210 ,300 ,25 );
		amount.setFont(new Font("Raleway",Font.BOLD,22));
		add(amount);
		
		withdraw= new JButton("Withdraw");
		withdraw.setBounds(300,345,140,30);
		withdraw.addActionListener(this);
	    label.add(withdraw);
	    
	    back= new JButton("Back");
	    back.setBounds(300,380,140,30);
		back.addActionListener(this);
	    label.add(back);
		
		setSize(800,750);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		
		if(ae.getSource()== withdraw)
		{
			String number=amount.getText();
			Date date=new Date();
			if(number.equals("")) 
			{
				JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");
			}
			else 
			{
				try {
				Conn conn=new Conn();
				String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
				conn.s.executeUpdate(query);	
				JOptionPane.showMessageDialog(null,"Rs "+number+ "Withdrawed Successfully");
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
				}
				catch(Exception e){
					System.out.println(e);		
				}
			}
				
		}
		else if(ae.getSource()== back)
		{
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Withdrawl("");

	}

}
